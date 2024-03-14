package com.wordwave.user.userLearnPerformance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

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
	private static final String CATEGORY_TOEIC = "TOEIC";
	
	
	@Autowired
	UserLearnPerformanceService userLearnPerformanceService;
	@Autowired
	UserLearnPerformanceRepository userLearnPerformanceRepository;
	@Autowired
	UserService userService;
	
	
	@Test
	@Transactional
	@DisplayName("학습이력 생성을 테스트하고, 중복 생성시, 해당 이력을 업데이트 하는지 테스트한다.")
	void createTest() {
		
		UserLearnPerformanceDTO firstTest = UserLearnPerformanceDTO.builder()
															 .learnType(LEARN_TYPE_VOCA)
															 .category(CATEGORY_TOEIC)
															 .answerCount(5)
															 .wrongCount(33)
															 .lastAttempted(LocalDateTime.now())
															 .build();
															 
		userLearnPerformanceService.create(firstTest, TEST_USER_ID);
		
		UserLearnPerformanceDTO secondTest = UserLearnPerformanceDTO.builder()
				 .learnType(LEARN_TYPE_VOCA)
				 .category(CATEGORY_TOEIC)
				 .answerCount(12)
				 .wrongCount(25)
				 .lastAttempted(LocalDateTime.now())
				 .build();
		userLearnPerformanceService.create(secondTest, TEST_USER_ID);
		
		SiteUser testUser = userService.getByUserId(TEST_USER_ID);
		UserLearnPerformance userLearnHistory = userLearnPerformanceRepository.findByUserAndCategory(testUser, CATEGORY_TOEIC);
		
		//중복 생성시 마지막에 했던 answerCount(12),wrongCount(25)가 되는지 확인한다.
		assertEquals(userLearnHistory.getAnswerCount(), 12);
		assertEquals(userLearnHistory.getWrongCount(), 25);
		System.out.println(userLearnHistory.getAnswerCount());
		System.out.println(userLearnHistory.getWrongCount());
	}
	
	
}