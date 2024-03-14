package com.wordwave.user.userLearnPerformance;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLearnPerformanceService {
	private final UserLearnPerformanceRepository userLearnPerformanceRepository;
	private final UserService userService;
	
	@Transactional
	public void create(UserLearnPerformanceDTO userLearnPerformanceDTO,long userId) {
		SiteUser user = userService.getByUserId(userId);
		UserLearnPerformance userLearn = userLearnPerformanceRepository.findByUserAndCategory(user, userLearnPerformanceDTO.getCategory());
		//학습한적이 없다면
		if(userLearn == null) {
			userLearn = UserLearnPerformance.builder()
					.user(user)
					.learnType(userLearnPerformanceDTO.getLearnType())
					.category(userLearnPerformanceDTO.getCategory())
					.answerCount(userLearnPerformanceDTO.getAnswerCount())
					.wrongCount(userLearnPerformanceDTO.getWrongCount())
					.lastAttempted(LocalDateTime.now())
					.build();

		}//학습한적이 있다면
		else {
			userLearn.updatePerformance(userLearnPerformanceDTO.getAnswerCount(), userLearnPerformanceDTO.getWrongCount());
		}
		userLearnPerformanceRepository.save(userLearn);
	}
	
	
	public UserLearnHistoryDTO getUserLearnHistory(String category,long userId) {
		SiteUser user = userService.getByUserId(userId);
		UserLearnPerformance userLearn = userLearnPerformanceRepository.findByUserAndCategory(user, category);
		if(userLearn == null) {
			return UserLearnHistoryDTO.builder().existence(false).build();
		}else {
			return UserLearnHistoryDTO.builder()
									  .answerCount(userLearn.getAnswerCount())
									  .wrongCount(userLearn.getWrongCount())
									  .existence(true)
									  .lastAttempted(userLearn.getLastAttempted())
									  .build();
		}
	}
	
}
