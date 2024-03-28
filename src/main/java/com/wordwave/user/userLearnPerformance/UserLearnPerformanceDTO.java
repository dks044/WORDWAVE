package com.wordwave.user.userLearnPerformance;

import java.time.LocalDateTime;

import com.wordwave.user.SiteUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLearnPerformanceDTO {

	private int id;
	
    private long userId;
    
    //종류(어떤것인지 : 보카, 그래머)
    // 1 : 보카
    // 2 : 그래머
    private Integer learnType;
    
    private String category;
    
    private Integer answerCount;
    
    private Integer wrongCount;

    private LocalDateTime lastAttempted;
}
