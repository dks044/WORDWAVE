package com.wordwave.myvoca;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wordwave.myvocabook.MyVocaBook;
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
public class MyVoca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String korWord;
	
	private String engWord;

	private String category;
	
	@ManyToOne
	@JsonBackReference
	private MyVocaBook myVocaBook;
	
    private String imgURL;
    
    @Builder
    public MyVoca(String korWord, String engWord,String category, String imgURL,MyVocaBook myVocaBook) {
    	this.korWord = korWord;
    	this.engWord = engWord;
    	this.category = category;
    	this.imgURL = imgURL;
    	this.myVocaBook = myVocaBook;
    }
    
}

