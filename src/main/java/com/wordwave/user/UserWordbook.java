package com.wordwave.user;

import com.wordwave.vocabook.Vocabook;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class UserWordbook {
	@ManyToOne
	private SiteUser user;
	
	@ManyToOne
	private Vocabook vocabook;

	//클리어여부
	private boolean isCleared;
	
}
