package com.wordwave.myvoca.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class MyVocaDTO{
	private String korWord;
	private String engWord;
	private String category;
}
@Getter
@Setter
@NoArgsConstructor
public class MyVocaCreateFormDTO {
	private long myVocaBookId;
	private long userId;
	private List<MyVocaDTO> myVocas;
}
