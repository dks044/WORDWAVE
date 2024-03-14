package com.wordwave.user.userLearnPerformance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UserLearnPerformanceTest {
	private static final long TEST_USER_ID = 2;
	private static final int LEARN_TYPE_VOCA = 1;
	private static final int LEARN_TYPE_GRAMMER = 2;
	private static final String CATEGORY_OF_TOEIC = "채용";
	
	
	@Autowired
	UserLearnPerformanceService userLearnPerformanceService;
	@Autowired
	UserLearnPerformanceRepository userLearnPerformanceRepository;
	@Autowired
	UserService userService;
	
	
	
	@Test
	@Transactional
	@DisplayName("학습이력 생성을 테스트하고, 중복 생성시, 해당 이력을 업데이트 하는지 테스트한다.")
	@Rollback(false)
	@Disabled
	void createTest() {//테스트성공
		
		UserLearnPerformanceDTO firstTest = UserLearnPerformanceDTO.builder()
															 .learnType(LEARN_TYPE_VOCA)
															 .userId(TEST_USER_ID)
															 .category(CATEGORY_OF_TOEIC )
															 .answerCount(5)
															 .wrongCount(33)
															 .lastAttempted(LocalDateTime.now())
															 .build();
															 
		userLearnPerformanceService.create(firstTest);
		
		UserLearnPerformanceDTO secondTest = UserLearnPerformanceDTO.builder()
				 .learnType(LEARN_TYPE_VOCA)
				 .userId(TEST_USER_ID)
				 .category(CATEGORY_OF_TOEIC )
				 .answerCount(12)
				 .wrongCount(25)
				 .lastAttempted(LocalDateTime.now())
				 .build();
		userLearnPerformanceService.create(secondTest);
		
		SiteUser testUser = userService.getByUserId(TEST_USER_ID);
		UserLearnPerformance userLearnHistory = userLearnPerformanceRepository.findByUserAndCategory(testUser, CATEGORY_OF_TOEIC);
		
		//중복 생성시 마지막에 했던 answerCount(12),wrongCount(25)가 되는지 확인한다.
		assertEquals(12, userLearnHistory.getAnswerCount());
		assertEquals(25,userLearnHistory.getWrongCount());
		System.out.println(userLearnHistory.getAnswerCount());
		System.out.println(userLearnHistory.getWrongCount());
	}
	
	@Test
	@DisplayName("학습이력 조회 테스트")
	@Disabled
	void getUserLearnHistoryTest() { //테스트성공
		UserLearnHistoryDTO userLearnHistoryDTO = userLearnPerformanceService.getUserLearnHistory(CATEGORY_OF_TOEIC, TEST_USER_ID);
		System.out.println("======= USER 학습이력 테스트 =======");
		System.out.println(userLearnHistoryDTO.getAnswerCount());
		System.out.println(userLearnHistoryDTO.getWrongCount());
		System.out.println(userLearnHistoryDTO.getLastAttempted());
		System.out.println("======= USER 학습이력 테스트 =======");
	}
	
}
