package com.wordwave.user;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.ResponseDTO;
import com.wordwave.security.TokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class UserController {
	private final UserService userService;
	private final TokenProvider tokenProvider;
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
		try {
			if(userDTO == null || userDTO.getPassword() == null) {
				throw new RuntimeException("Invalid Password value");
			}
			SiteUser user = SiteUser.builder()
									.userName(userDTO.getUserName())
									.password(userDTO.getPassword())
									.email(userDTO.getPassword())
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
	public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO){
		SiteUser user = userService.getByCredentials(
				userDTO.getUserName(),
				userDTO.getPassword());
		if(user != null) {
			final String token = tokenProvider.create(user);
			final UserDTO responseDTO = UserDTO.builder()
												.userName(user.getUserName())
												.id(user.getId())
												.token(token)
												.build();
			return ResponseEntity.ok().body(responseDTO);
		}else {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error("Login Falid")
					.build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
	
}
