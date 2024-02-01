package com.wordwave.user;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.emailcode.EmailAuthenicateDTO;
import com.wordwave.emailcode.EmailCode;
import com.wordwave.emailcode.EmailCodeService;
import com.wordwave.security.Key;
import com.wordwave.security.TokenProvider;
import com.wordwave.util.MailDTO;
import com.wordwave.util.MailService;
import com.wordwave.util.ResponseDTO;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class UserController {
	private final UserService userService;
	private final TokenProvider tokenProvider;
	private static final byte[] JWT_SECRET_KEY = Key.JWT_SECREAT_KEY.getValueBytes();
	private final PasswordEncoder passwordEncoder;
	private final MailService mailService;
	private final EmailCodeService emailCodeService;
	
	@PostMapping("/send_authenticateCode")
	public ResponseEntity<?> authenticateSendEmailCode(@RequestBody EmailAuthenicateDTO emailAuthenicateDTO){
		String sendCode = mailService.createRandomPW();
		emailAuthenicateDTO.setEmailCode(sendCode);
		String subject = "[WORDWAVE] 인증코드 입니다.";
		try {
			MailDTO mailDTO = new MailDTO();
			mailDTO.setEmail(emailAuthenicateDTO.getEmail());
			if(userService.equalsDatabaseByEmail(emailAuthenicateDTO.getEmail())) {
				return ResponseEntity.status(401).body("해당 이메일에 코드를 전송할 수 없습니다.");
			}
			StringBuilder sendMessage = new StringBuilder();
			sendMessage.append("인증코드 입니다.. <br>");
			sendMessage.append(sendCode+"<= 해당 임시코드를 입력 하세요.<br>");
			sendMessage.append("감사합니다.<br>");
			EmailCode emailCodeEntity = emailCodeService.converterToEntity(emailAuthenicateDTO);
			if(emailCodeService.isEmail(emailAuthenicateDTO.getEmail())) {
				return ResponseEntity.status(HttpStatus.OK).body("이미 이메일에 코드를 전송했습니다.");
			}else emailCodeService.save(emailCodeEntity);
			mailService.sendEmail(mailDTO, subject, sendMessage.toString());
			return ResponseEntity.ok().body("email send success.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("이메일 인증 코드 전송 실패");
		}
	}
	
	@PostMapping("authenticateCode")
	public ResponseEntity<?> authenticateEmailCode(@RequestBody EmailAuthenicateDTO emailAuthenicateDTO){
		try {
			EmailCode emailCode =
			emailCodeService.getByCredentials(emailAuthenicateDTO.getEmail(),emailAuthenicateDTO.getEmailCode());
			if(emailCode == null) {
				return ResponseEntity.status(401).body("이메일 인증 코드가 맞지 않음");
			}
			return ResponseEntity.ok().body("이메일 인증 성공");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("이메일 인증 코드가 맞지 않음.");
		}
	}
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
		try {
			if(userDTO == null || userDTO.getPassword() == null) {
				throw new RuntimeException("Invalid Password value");
			}
			SiteUser user = SiteUser.builder()
									.userName(userDTO.getUserName())
									.password(passwordEncoder.encode(userDTO.getPassword()))
									.email(userDTO.getEmail())
									.phoneNumber(userDTO.getPhoneNumber())
									.createUserDate(LocalDateTime.now())
									.point(0)
									.build();
			SiteUser registeredUser = userService.create(user);
			UserDTO responseDTO = UserDTO.builder()
										 .id(registeredUser.getId())
										 .userName(registeredUser.getUserName())
										 .password(registeredUser.getPassword())
										 .email(registeredUser.getEmail())
										 .phoneNumber(registeredUser.getPhoneNumber())
										 .createUserDate(registeredUser.getCreateUserDate())
										 .point(registeredUser.getPoint())
										 .build();
			return ResponseEntity.ok().body(responseDTO);
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity
								.badRequest()
								.body(responseDTO);
		}
		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticate(
	        @RequestBody UserDTO userDTO,
	        HttpServletResponse response
	        ){
	    SiteUser user = userService.getByUserName(userDTO.getUserName());
	    if(user != null && passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
	        final String token = tokenProvider.create(user,response);
	        final UserDTO responseDTO = UserDTO.builder()
	                .userName(user.getUserName())
	                .email(user.getEmail())
	                .phoneNumber(user.getPhoneNumber())
	                .id(user.getId())
	                .build();
	        Cookie cookie = new Cookie("token", token);
	        cookie.setHttpOnly(true);
	        response.addCookie(cookie);
	        return ResponseEntity.ok().body(responseDTO);
	    }else {
	        ResponseDTO responseDTO = ResponseDTO.builder()
	                .error("Login Failed")
	                .build();
	        log.info("utf-8", responseDTO.getError(), responseDTO);
	        return ResponseEntity.badRequest().body(responseDTO);
	    }
	}
	
	@PostMapping("/signout")
	public ResponseEntity<?> signOut(HttpServletResponse response){
	    Cookie cookie = new Cookie("token", null); 
	    cookie.setHttpOnly(true);
	    cookie.setMaxAge(0); 
	    response.addCookie(cookie); //HTTP 응답에 쿠키를 추가
	    return ResponseEntity.ok().body("Logged out");
	}
	
	@PostMapping("/validateToken")
	public ResponseEntity<?> validateToken(
			HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error("Cookie is empty")
					.build();
			return ResponseEntity.status(401).body(responseDTO);
		}
	    String token = null;
	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals("token")) {
	            token = cookie.getValue();
	            break;
	        }
	    }
		
	    if (token == null) {
	        ResponseDTO responseDTO = ResponseDTO.builder()
	                .error("Token is empty")
	                .build();
	        return ResponseEntity.status(401).body(responseDTO);
	    }
	    //토큰을 찾았을떄 검사시작
	    try {
			Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY).build().parseClaimsJws(token);
		} catch (JwtException e) {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error("Token is invalid")
					.build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	    
		return ResponseEntity.ok().body("validate success");
	}
	
	@PostMapping("/find_username")
	public ResponseEntity<?> findUserName(
										HttpServletResponse response,
										@RequestBody MailDTO mailDTO
			){
		String subject = "[WORDWAVE] 찾으신 아이디 입니다.";
		try {
			String findedUserName = userService.getUserNameByEmail(mailDTO.getEmail());
			StringBuilder sendMessage = new StringBuilder();
			sendMessage.append("아이디 찾기 결과 입니다.<br>");
			sendMessage.append(findedUserName+"<= 해당 아이디로 로그인하세요.<br>");
			sendMessage.append("감사합니다.<br>");
			mailService.sendEmail(mailDTO,subject,sendMessage.toString());
			return ResponseEntity.ok().body(findedUserName);
		} catch (DataAccessException e) {
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("데이터베이스 오류");
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("유효하지 않은 이메일");
		}
	}
	
	@PostMapping("/find_password")
	public ResponseEntity<?> findPassWord(HttpServletResponse response,
										  @RequestBody MailDTO mailDTO){
		String subject = "[WORDWAVE] 임시 비밀번호 입니다.";
		try {
			SiteUser user = userService.getSiteUserByUserNameAndEmail(mailDTO.getUserName(), mailDTO.getEmail());
			String newPassword = mailService.createRandomPW();
			userService.changeUserPassword(user, passwordEncoder.encode(newPassword));
			StringBuilder sendMessage = new StringBuilder();
			sendMessage.append("반갑습니다 ");
			sendMessage.append(user.getUserName()+" 님<br>");
			sendMessage.append("임시 비밀번호 발급해드리겠습니다.<br>");
			sendMessage.append(newPassword+"<= 해당 임시 비밀번호로 로그인하세요.<br>");
			sendMessage.append("감사합니다.<br>");
			mailService.sendEmail(mailDTO,subject,sendMessage.toString());
			return ResponseEntity.ok().body("비밀번호 이메일 전송완료");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("유효하지 않은 이메일과 아이디");
		}
	}
	
	@PostMapping("/change_password")
	public ResponseEntity<?> changePassword(
	    HttpServletRequest request,
	    @RequestBody MyPageDTO myPageDTO
	) {
	    try {
	    	String token = userService.getTokenFromRequest(request);
		    if(token == null) return ResponseEntity.badRequest().body("Token is empty");
		    long userId = userService.getUserIdFromJwt(token);
	    	SiteUser user = userService.getByUserId(userId);
	    	if(!passwordEncoder.matches(myPageDTO.getPassword(), user.getPassword())){
	    		return ResponseEntity.status(401).body("원래 비밀번호와 입력한 비밀번호가 다릅니다.");
	    	}
	    	userService.changeUserPassword(user, passwordEncoder.encode(myPageDTO.getNewPassword()));
	        return ResponseEntity.ok().body("Password changed");
	    } catch (JwtException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid");
	    }
	}

	@PostMapping("/delete_user")
	public ResponseEntity<?> deleteUser(HttpServletRequest request, @RequestBody MyPageDTO myPageDTO){
		try {
			String token = userService.getTokenFromRequest(request);
			SiteUser user = userService.getByUserId(userService.getUserIdFromJwt(token));
			if(!user.getEmail().equals(myPageDTO.getEmail()) || !passwordEncoder.matches(myPageDTO.getPassword(), user.getPassword())) {
				return ResponseEntity.status(401).body("입력한 비밀번호와 이메일이 가입 정보와 다릅니다.");
			}
			userService.deleteUser(user);
			return ResponseEntity.ok().body(user.getId()+"<= user deleted.");
		} catch (JwtException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid");
		}
	}
	
	
}
