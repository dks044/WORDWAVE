package com.wordwave.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String phoneNumber;
    
    //회원가입일
    private LocalDateTime createUserDate;
    
    //레이팅 (레이팅에 따라 티어 부여)
    private long point;
    
    private UserRole role = UserRole.USER;
    

}
