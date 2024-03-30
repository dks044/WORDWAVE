package com.wordwave.myvocabook.dto;


import com.wordwave.user.SiteUser;

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
	MyVocaBookDTO(String name, String imageURL,SiteUser user){
		this.name = name;
		this.imageURL = imageURL;
	}
}
