package com.wordwave.myvocabook.dto;



import lombok.Builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MyVocaBookDTO {
	private Long id;
	private String name;
	private String imageURL;
	
	@Builder
	MyVocaBookDTO(Long id,String name, String imageURL){
		this.id = id;
		this.name = name;
		this.imageURL = imageURL;
	}
}
