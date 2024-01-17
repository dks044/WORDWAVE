package com.wordwave.user;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.ResponseDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class UserController {
	private final UserService userService;
	
	@PostMapping("/signUp")
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
	
}
