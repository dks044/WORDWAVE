package com.wordwave.myvoca.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyVocaDTO{
	private String korWord;
	private String engWord;

	@Builder
	MyVocaDTO(String korWord,String engWord){
		this.korWord = korWord;
		this.engWord = engWord;

	}
}
