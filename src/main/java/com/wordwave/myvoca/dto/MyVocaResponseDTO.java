package com.wordwave.myvoca.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyVocaResponseDTO {
	private Long id;
	private String korWord;
    private String engWord;
    private String category;
    private Long myVocaBookId;
    private String imgURL;
    //중간에 빈칸이 있는 영단어
    public String hiddenEngWord;
    //영어빈칸퀴즈 : 1 | 한글제시퀴즈 : 2
    public int quizStatus;
    public Set<String> randomEngWord = new HashSet<>();
	
}
