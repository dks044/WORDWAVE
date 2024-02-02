package com.wordwave.emailcode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailAuthenicateDTO {
	private String email;
	private String emailCode;
}
