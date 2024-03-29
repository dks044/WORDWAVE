package com.wordwave.vocabook;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wordwave.voca.Voca;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
public class VocaBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "vocaBook")
	@JsonManagedReference
	private List<Voca> vocas = new ArrayList<>();
	
	protected VocaBook() {
    }
	
	public VocaBook(String name) {
        this.name = name;
    }
	//s3경로
	private String imageURL;
	
	@Builder
	VocaBook(String name, String imageURL){
		this.name = name;
		this.imageURL = imageURL;
	}
	
}
