package com.wordwave.user.userLearnPerformance;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	
	//TODO: 학습이력 생성 및 연속 학습일 계산
	@Transactional
	public void create(UserLearnPerformanceDTO userLearnPerformanceDTO) {
		long userId = userLearnPerformanceDTO.getUserId();
		SiteUser user = userService.getByUserId(userId);
		UserLearnPerformance userLearn = userLearnPerformanceRepository.findByUserAndCategory(user, userLearnPerformanceDTO.getCategory());
		
		Pageable pageable = PageRequest.of(0, 1); 
		List<UserLearnPerformance> results = userLearnPerformanceRepository.findLastAttemptedByUserId(userId,pageable);
		
		//사용자 마지막 학습이력
		LocalDateTime userlastAttempted = null;
		if (!results.isEmpty()) {
			userlastAttempted = results.get(0).getLastAttempted();
		}

		
		//해당 카테고리를 학습한적이 없다면
		if(userLearn == null) {
			userLearn = UserLearnPerformance.builder()
					.user(user)
					.learnType(userLearnPerformanceDTO.getLearnType())
					.category(userLearnPerformanceDTO.getCategory())
					.answerCount(userLearnPerformanceDTO.getAnswerCount())
					.wrongCount(userLearnPerformanceDTO.getWrongCount())
					.lastAttempted(LocalDateTime.now())
					.build();
		}//해당 카테고리를 학습한적이 있다면
		else {
			userLearn.updatePerformance(userLearnPerformanceDTO.getAnswerCount(), userLearnPerformanceDTO.getWrongCount());
		}
		
		//현재 생성한 학습이력과 사용자의 마지막 학습이력을 비교해서 연속 학습 계산
		long daysBetween = 1; //학습이력 차이일 계산
		if(userlastAttempted != null) {//user가 학습한 이력이 있을경우
			daysBetween = ChronoUnit.DAYS.between(userlastAttempted, userLearn.getLastAttempted());
		}
        if (daysBetween == 1) {
            // 연속 출석일 증가
            userService.increaseUserConsecutiveLearningDays(userId);
        } else if (daysBetween > 1) {
            // 연속 출석일 리셋
            userService.resetUserConsecutiveLearningDays(userId);
        }
				
		userLearnPerformanceRepository.save(userLearn);
	}
	
	@Transactional
	public UserLearnHistoryDTO getUserLearnHistory(String category,long userId) {
		SiteUser user = userService.getByUserId(userId);
		UserLearnPerformance userLearn = userLearnPerformanceRepository.findByUserAndCategory(user, category);
		//System.out.println(userLearn); //null이 나옴.
		//학습이력이 존재하지 않다면
		if(userLearn == null) {
			return UserLearnHistoryDTO.builder().existence(false).build();
		}//학습이력이 존재하다면
		else {
			
			return UserLearnHistoryDTO.builder()
									  .learnType(userLearn.getLearnType())
									  .answerCount(userLearn.getAnswerCount())
									  .wrongCount(userLearn.getWrongCount())
									  .existence(true)
									  .lastAttempted(userLearn.getLastAttempted())
									  .build();
		}
	}

	
}
