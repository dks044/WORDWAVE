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
public class UserDTO {
	private long id;
	private String token;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private LocalDateTime createUserDate;
	private UserRole role;
	private long point;
	private LocalDateTime consecutiveLearningDays;
}
