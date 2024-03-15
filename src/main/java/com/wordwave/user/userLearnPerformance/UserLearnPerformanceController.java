package com.wordwave.user.userLearnPerformance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/userLearn")
public class UserLearnPerformanceController {
	private final UserLearnPerformanceService userLearnPerformanceService;
	
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
	public ResponseEntity<?> getUserLearnHistory(@RequestBody UserLearnPerformanceDTO userLearnPerformanceDTO){
		try {
			return ResponseEntity.ok().body(userLearnPerformanceService.getUserLearnHistory(userLearnPerformanceDTO.getCategory(),
																	userLearnPerformanceDTO.getUserId()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("학습이력 불러오기 실패!");
		}
	}
	
}
