package com.wordwave.voca;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wordwave.vocabook.VocaBook;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Voca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String korWord;
	
	private String engWord;

	private String category;
	
	@ManyToOne
	@JsonBackReference
	private VocaBook vocaBook;
	
    private String imgURL;
    
    @Builder
    public Voca(String korWord, String engWord,String category, String imgURL,VocaBook vocaBook) {
    	this.korWord = korWord;
    	this.engWord = engWord;
    	this.category = category;
    	this.imgURL = imgURL;
    	this.vocaBook = vocaBook;
    }
}
