package com.wordwave.myvoca.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class MyVocaUpdateFormRequestDTO {
	long myVocaBookId;
	long userId;
	String prevCategory; //이전 카테고리 (원래카테고리)
	String nextCategory; //수정할 카테고리
	List<MyVocaDTO> myVocas;
	
	@Builder
	MyVocaUpdateFormRequestDTO(long myVocaBookId,
							   long userId,
							   String prevCategory,
							   String nextCategory,
							   List<MyVocaDTO> myVocas){
		this.myVocaBookId = myVocaBookId;
		this.userId = userId;
		this.prevCategory = prevCategory;
		this.nextCategory = nextCategory;
		this.myVocas = myVocas;
	}
}
