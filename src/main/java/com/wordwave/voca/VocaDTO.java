package com.wordwave.voca;

import java.time.LocalDateTime;

import com.wordwave.user.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VocaDTO {
	private Long id;
	private String korWord;
    private String engWord;
    private String category;
    private Long vocaBookId;
    private String imgURL;
    //중간에 빈칸이 있는 영단어
    public String hiddenEngWord;
    //한글퀴즈 : 1 / 영어퀴즈 : 2
    public int quizStatus;
}
