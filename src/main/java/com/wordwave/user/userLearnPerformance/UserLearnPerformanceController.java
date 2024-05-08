package com.wordwave.user.userLearnPerformance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "UserLearnPerformance",description = "사용자 학습 이력 관련 API")
@RequestMapping("/api/userLearn")
public class UserLearnPerformanceController {
	private final UserLearnPerformanceService userLearnPerformanceService;
	
	@Operation(
			summary = "사용자 학습이력 생성",
			description = "사용자가 퀴즈(voca,grammar,나만의 단어장)를 수행한 정보를 서버에 업로드한다."
			)
	@PostMapping("/create_userLearnPerformance")
	public ResponseEntity<?> createUserLearnPerformance(@RequestBody UserLearnPerformanceDTO userLearnPerformanceDTO){
		try {
			userLearnPerformanceService.create(userLearnPerformanceDTO);
			return ResponseEntity.ok().body("학습이력 생성완료");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("학습이력 생성실패!");
		}
	}
	
	@Operation(
			summary = "특정 퀴즈의 사용자 학습이력 조회",
			description = "사용자의 id와 해당 퀴즈 category를 통해 사용자 학습이력을 조회한다."
			)
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
	@Operation(
			summary = "사용자 학습이력 전체 조회",
			description = "사용자가 퀴즈(voca,grammar,나만의 단어장)를 수행한 전체 정보를 조회한다."
			)
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
