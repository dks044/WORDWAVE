package com.wordwave.grammar;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Grammar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//ex: "She __ a book now."
	private String engSentence;
	
	//ex: "She is reading a book now."
	private String originEngSentence;
	
	//ex: "그녀는 지금 책을 읽고 있다."
	private String korSentence;
	
	//정답
	//ex: "is reading"
	private String answer;
	
	private List<String> blackOptions;
	
	//userLearnPerformance와 연계됨.
	//ex: "현재와 현재진행"
	private String category;
	

}
