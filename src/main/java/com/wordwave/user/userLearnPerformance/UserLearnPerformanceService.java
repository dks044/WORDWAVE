package com.wordwave.user.userLearnPerformance;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
					.lastAttempted(LocalDateTime.now(ZoneId.of("UTC")))
					.build();
		}//해당 카테고리를 학습한적이 있다면
		else {
			userLearn.updatePerformance(userLearnPerformanceDTO.getAnswerCount(), userLearnPerformanceDTO.getWrongCount());
		}
		
		//현재 생성한 학습이력과 사용자의 마지막 학습이력을 비교해서 연속 학습 계산
		long daysBetween = 1; //학습이력 차이일 계산
		if(userlastAttempted != null) {//user가 학습한 이력이 있을경우
			daysBetween = ChronoUnit.DAYS.between(userlastAttempted, userLearn.getLastAttempted());
//			System.out.println("userLearn.getLastAttempted() => "+userLearn.getLastAttempted());
//			System.out.println("userlastAttempted => "+ userlastAttempted);
//			System.out.println("daysBetween => "+daysBetween);
		} 
        if (daysBetween == 1) {
            // 연속 출석일 증가
        	//System.out.println("증가!");
            userService.increaseUserConsecutiveLearningDays(userId);
        } else if (daysBetween > 1) {
            // 연속 출석일 리셋
        	//System.out.println("감소!");
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

	public Page<UserLearnPerformanceDTO> getAllUserLearnPerformance(long userId,int pageNum){
		//descending() 최신순
		Pageable pageable = PageRequest.of(pageNum, 5, Sort.by("lastAttempted").descending());
		Page<UserLearnPerformance> ulpPage = userLearnPerformanceRepository.findAllByUserId(userId, pageable);
		// Java 8 스트림 API를 사용하여 엔티티 리스트를 DTO 리스트로 변환합니다.
				Page<UserLearnPerformanceDTO> ulpDTOPage = ulpPage.map(ulp -> UserLearnPerformanceDTO.builder()
																			.learnType(ulp.getLearnType())
																			.category(ulp.getCategory())
																			.answerCount(ulp.getAnswerCount())
																			.wrongCount(ulp.getWrongCount())
																			.lastAttempted(ulp.getLastAttempted())
																			.build());
				

		return ulpDTOPage;
	}
	
}
