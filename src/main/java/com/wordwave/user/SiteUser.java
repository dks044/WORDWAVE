package com.wordwave.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false, length = 50)
	private String userName;
	
	private String password;
	
	@Column(unique = true)
    private String email;
	
    @Column(unique = true)
    private String phone_number;
    
    //회원가입일
    private LocalDateTime createUserDate;
    
    //TODO: 단어장 매핑,문법장 매핑
	
	
}
