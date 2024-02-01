package com.wordwave.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyPageDTO {
	//비밀번호 변경폼
	public String password; //<= 회원탈퇴폼에도 이용함.
	public String newPassword;
	
	//회원탈퇴 폼
	public String email;
}
