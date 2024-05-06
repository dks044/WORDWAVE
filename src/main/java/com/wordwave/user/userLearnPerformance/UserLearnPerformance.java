package com.wordwave.user.userLearnPerformance;

import java.time.LocalDateTime;

import com.wordwave.user.SiteUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//SiteUser가 틀린 단어,문법 퀴즈를 카운팅 받는 엔티티
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLearnPerformance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    private SiteUser user;
    
    //종류(어떤것인지 : 보카, 그래머)
    // 1 : 보카
    // 2 : 그래머
    // 3 : 사용자단어장
    private Integer learnType;
    
    //카테고리(챕터)
    private String category;
    
    //정답카운트
    private Integer answerCount;
    
    //오답카운트
    private Integer wrongCount;
    
    //마지막 문제를 푼 기록
    private LocalDateTime lastAttempted;
    
    @Builder
    public UserLearnPerformance(SiteUser user,
    							Integer learnType,
    							String category,
    							Integer answerCount,
    							Integer wrongCount,
    							LocalDateTime lastAttempted) {
		this.user =user;
		this.learnType = learnType;
		this.category = category;
		this.answerCount = answerCount;
		this.wrongCount = wrongCount;
		this.lastAttempted = LocalDateTime.now();
	}
    
    public void updatePerformance(int answerCount, int wrongCount) {
        this.answerCount = answerCount;
        this.wrongCount = wrongCount;
        this.lastAttempted = LocalDateTime.now();
    }

}
