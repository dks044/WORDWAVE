package com.wordwave.grammar;

import java.util.List;

import com.wordwave.grammarBook.GrammarBook;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
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
	
	@ElementCollection(fetch = FetchType.LAZY)
	//ex: ["read", "reads", "is reading", "are reading"]
	private List<String> blackOptions;
	
	//userLearnPerformance와 연계됨.
	//ex: "현재와 현재진행"
	private String category;
	
	// Grammar 클래스 내 추가
	@ManyToOne
	@JoinColumn(name = "grammarBook_id")
	private GrammarBook grammarBook;
	
	@Builder
	Grammar(String engSentence, String originEngSentence,String korSentence, String answer, List<String> blackOptions,
			String category,GrammarBook grammarBook){
		this.engSentence = engSentence;
		this.originEngSentence = originEngSentence;
		this.korSentence = korSentence;
		this.answer = answer;
		this.blackOptions = blackOptions;
		this.category = category;
		this.grammarBook = grammarBook;
	}
}
