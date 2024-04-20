package com.wordwave.myvoca.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Builder
public class MyVocaCreateFormDTO {
	private long myVocaBookId;
	private long userId;
	private String category;
	private List<MyVocaDTO> myVocas;
	
	MyVocaCreateFormDTO(long myVocaBookId,long userId,String category,List<MyVocaDTO> myVocas){
		this.myVocaBookId =myVocaBookId;
		this.userId = userId;
		this.category = category;
		this.myVocas = myVocas;
	}
	
}
