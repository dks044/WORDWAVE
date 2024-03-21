package com.wordwave.grammar;

import java.util.List;

import com.wordwave.grammarBook.GrammarBook;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GrammarDTO {

	private long id;

	private String engSentence;
	
	private String originEngSentence;
	
	private String korSentence;

	private String answer;
	
	private List<String> blackOptions;
	
	private String category;
	
	private GrammarBook grammarBook;
	
	//퀴즈용도
	// 1 (객관식) , 2 (주관식)
	private int quizStatus;
}
