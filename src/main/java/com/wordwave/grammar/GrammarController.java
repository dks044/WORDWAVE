package com.wordwave.grammar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/grammar")
@Tag(name = "Grammar",description = "기본 영어 문법 관련 API")
public class GrammarController {
	private final GrammarService grammarService;
	@Operation(
			summary = "문법 퀴즈",
			description = "사용자가 영어 문법 퀴즈를 수행할 수 있도록 클라이언트에 데이터를 전송한다."
			)
	@GetMapping("/{grammarBookId}/{category}")
	public ResponseEntity<?> select(@PathVariable("grammarBookId") long grammarBookId,
									@PathVariable("category") String category){
		try {
			return ResponseEntity.ok().body(grammarService.select(grammarBookId, category));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("grammar 퀴즈 데이터 불러오기 실패!");
		}
	}
			
	
}
