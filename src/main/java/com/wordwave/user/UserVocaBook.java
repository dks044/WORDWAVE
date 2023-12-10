package com.wordwave.user;

import com.wordwave.vocabook.VocaBook;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class UserVocaBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private SiteUser user;
	
	@ManyToOne
	@JoinColumn(name = "vocabook_id", referencedColumnName = "id")
	private VocaBook vocaBook;

	//클리어여부
	private boolean isCleared;
	
}
