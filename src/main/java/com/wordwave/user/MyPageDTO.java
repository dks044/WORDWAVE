package com.wordwave.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyPageDTO {
	//비밀번호 변경폼
	public String password;
	public String newPassword;
}
