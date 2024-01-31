package com.wordwave.user;

import java.time.LocalDateTime;
import java.util.Collections;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	//TODO: 이후 삭제 예정
	@PreAuthorize("isAuthenticated()")
    @GetMapping("/test")
    public String test() {
        return "Login logic Test";
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
		} catch (Exception e) {//TODO: 추후에 더 구체적인 예외 클래스를 작성해야함.
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
	    SiteUser user = userService.getByCredentials(
	            userDTO.getUserName(),
	            userDTO.getPassword());
	    if(user != null) {
	        final String token = tokenProvider.create(user,response);
	        final UserDTO responseDTO = UserDTO.builder()
	                                            .userName(user.getUserName())
	                                            .id(user.getId())
	                                            .build();
	        Cookie cookie = new Cookie("token", token);
	        cookie.setHttpOnly(true);
	        response.addCookie(cookie);
	        return ResponseEntity.ok().body(responseDTO);
	    }else {
	        ResponseDTO responseDTO = ResponseDTO.builder()
	                .error("Login Falid")
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

}
