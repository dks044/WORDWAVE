package com.wordwave.myvocabook;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wordwave.myvoca.MyVoca;
import com.wordwave.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;


@Entity
@Getter
public class MyVocaBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
    @ManyToOne
    private SiteUser user;
	
    @OneToMany(mappedBy = "myVocaBook", cascade = CascadeType.ALL) 
	@JsonManagedReference
	private List<MyVoca> myVocas = new ArrayList<>();
	
	protected MyVocaBook() {
    }
	
	public MyVocaBook(String name) {
        this.name = name;
    }
	//s3경로
	private String imageURL;
	
	@Builder
	MyVocaBook(String name, String imageURL,SiteUser user){
		this.name = name;
		this.imageURL = imageURL;
		this.user = user;
	}
	
}

