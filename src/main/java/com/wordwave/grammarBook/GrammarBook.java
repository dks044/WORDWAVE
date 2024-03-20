package com.wordwave.grammarBook;

import java.util.ArrayList;
import java.util.List;

import com.wordwave.grammar.Grammar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class GrammarBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//ex : "기초 회화"
	@Column(unique = true, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "grammarBook")
	private List<Grammar> grammars = new ArrayList<>();
	
	//s3경로
	private String imageURL;
	
	@Builder
	GrammarBook(String name, String imageURL){
		this.name = name;
		this.imageURL = imageURL;
	}
	
}
