package com.wordwave.voca;

import java.util.ArrayList;
import java.util.List;

import com.wordwave.vocabook.VocaBook;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Voca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// TODO:korQuestion ,engQuestion 중 랜덤으로 
	
	//ex) Q: 사과 - A: 구글번역기 API를 사용한 사용자의 입력값 번역이 맞아 떨어질경우
	//TODO: KOR문제일 경우 영어 포함안되게 해야함.
	private String korWord;
	
	//ex) Q: apple - A: 구글번역기 API를 사용한 사용자의 입력값 번역이 맞아 떨어질경우
	//TODO: ENG문제일 경우 한국어 포함안되게 해야함.
	private String engWord;

	//ex: 채용, 법률 (챕터느낌) - 해커스토익보카
	private String category;
	
	@ManyToOne
	private VocaBook vocaBook;
	
    private String imgURL;
    
    //예외단어추가용도
    private List<String> exceptionVoca = new ArrayList<>();
    
    @Builder
    public Voca(String korWord, String engWord,String category, String imgURL,VocaBook vocaBook) {
    	this.korWord = korWord;
    	this.engWord = engWord;
    	this.category = category;
    	this.imgURL = imgURL;
    	this.vocaBook = vocaBook;
    }
}
