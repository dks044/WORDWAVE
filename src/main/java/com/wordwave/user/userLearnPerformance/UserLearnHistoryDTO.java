package com.wordwave.user.userLearnPerformance;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLearnHistoryDTO {
	int answerCount;
	int wrongCount;
	boolean existence; //학습기록 존재 여부
	private LocalDateTime lastAttempted;
}
