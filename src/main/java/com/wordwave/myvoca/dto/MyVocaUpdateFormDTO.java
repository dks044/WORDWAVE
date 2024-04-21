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
public class MyVocaUpdateFormDTO {
	long myVocaBookId;
	String category;
	List<MyVocaDTO> myVocas;
	
	MyVocaUpdateFormDTO(long myVocaBookId, String category,List<MyVocaDTO> myVocas){
		this.myVocaBookId = myVocaBookId;
		this.category = category;
		this.myVocas = myVocas;
	}
}
