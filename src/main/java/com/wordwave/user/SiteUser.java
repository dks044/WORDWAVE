package com.wordwave.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wordwave.user.userLearnPerformance.UserLearnPerformance;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	private String token;
	
    @Column(length = 512)
    private String refreshToken;
	
	@Column(unique = true, nullable = false, length = 10)
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
    
    @Convert(converter = UserRoleConverter.class)
    private UserRole role = UserRole.USER;
    
    //연속학습일
    private long consecutiveLearningDays;
    
    //마지막로그인
    private LocalDateTime loginTimeStamp;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLearnPerformance> performances = new ArrayList<>();
    
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    public void changeConsecutiveLearningDays(long setDays) {
    	this.consecutiveLearningDays = setDays;
    }
    public void changeLoginTimeStamp(LocalDateTime loginTimeStamp) {
    	this.loginTimeStamp = loginTimeStamp;
    }
    
}
