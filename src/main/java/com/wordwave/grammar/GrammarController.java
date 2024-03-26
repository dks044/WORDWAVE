package com.wordwave.grammar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/grammar")
public class GrammarController {
	private final GrammarService grammarService;
	
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
