package com.wordwave.myvocabook.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class MyVocaBookFormDTO {
	private String name;
	private long myVocaBookId;
	private long userId;
	
	@Builder
	MyVocaBookFormDTO(String name,long userId){
		this.name = name;
		this.userId = userId;
	}
}
