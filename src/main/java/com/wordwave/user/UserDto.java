package com.wordwave.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private long id;
	private String token;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private LocalDateTime createUserDate;
	private long point;
}
