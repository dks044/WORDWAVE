package com.wordwave.myvocabook.dto;

import org.springframework.web.multipart.MultipartFile;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MyVocaBookFormDTO {
	private String name;
	private MultipartFile image;
	
	@Builder
	MyVocaBookFormDTO(String name, MultipartFile image){
		this.name = name;
		this.image = image;
	}
}
