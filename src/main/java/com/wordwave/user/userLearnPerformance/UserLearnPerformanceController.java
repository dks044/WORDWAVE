package com.wordwave.user.userLearnPerformance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/userLearn")
public class UserLearnPerformanceController {
	private final UserLearnPerformanceService userLearnPerformanceService;
	
	//TODO:학습이력을 조회하고, 그에따라 사용자에게 점수 부여하는 기능 추가해야함
	@PostMapping("/create_userLearnPerformance")
	public ResponseEntity<?> createUserLearnPerformance(@RequestBody UserLearnPerformanceDTO userLearnPerformanceDTO){
		try {
			userLearnPerformanceService.create(userLearnPerformanceDTO);
			return ResponseEntity.ok().body("학습이력 생성완료");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("학습이력 생성실패!");
		}
	}
	
	@GetMapping("/get_userLearnHistory")
	public ResponseEntity<?> getUserLearnHistory(@RequestParam("category") String category, 
	                                             @RequestParam("userId") long userId) {
	    try {
	        return ResponseEntity.ok().body(userLearnPerformanceService.getUserLearnHistory(category, userId));
	    } catch (Exception e) {
	    	e.printStackTrace(); // 콘솔에 스택 트레이스 출력
	        log.error("학습이력 생성 오류: ", e); // 로그 파일에 오류 기록
	        return ResponseEntity.badRequest().body("사용자 학습기록 불러오기 실패!");
	    }
	}
	
	@GetMapping("/get_allUserLearnPerformance")
	public ResponseEntity<?> getAllUserLearnPerformance(@RequestParam("userId") long userId,
														@RequestParam(value = "pageNum", defaultValue = "0") int pageNum){
		try {
			return ResponseEntity.ok().body(userLearnPerformanceService.getAllUserLearnPerformance(userId,pageNum));
		} catch (Exception e) {
	    	e.printStackTrace(); // 콘솔에 스택 트레이스 출력
	        log.error("학습이력 생성 오류: ", e); // 로그 파일에 오류 기록
	        return ResponseEntity.badRequest().body("사용자 학습이력 불러오기 실패!");
		}
	}
	
}
