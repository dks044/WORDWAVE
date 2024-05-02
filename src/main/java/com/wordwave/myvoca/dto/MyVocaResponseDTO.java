package com.wordwave.myvoca.dto;


import java.util.List;
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
    //중간에 빈칸이 있는 영단어
    private String hiddenEngWord;
    //영어빈칸퀴즈 : 1 | 한글제시퀴즈 : 2
    private int quizStatus;
    private List<String> randomEngWord;
	private String myVocaBookName;
}
