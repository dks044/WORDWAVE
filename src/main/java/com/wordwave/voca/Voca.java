package com.wordwave.voca;

import com.wordwave.vocabook.Vocabook;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Voca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// TODO:korQuestion ,engQuestion 중 랜덤으로 
	
	//ex) Q: 사과 - A: apple
	private String korQuestion;
	private String korAnswer;
	
	//ex) Q: apple - A: 사과
	private String engQuestion;
	private String engAnswer;
	
	@ManyToOne
	private Vocabook vocabook;
	
}
