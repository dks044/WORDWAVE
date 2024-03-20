package com.wordwave.grammarBook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/grammarBook")
@RequiredArgsConstructor
public class GrammarBookController {
	private final GrammarBookService grammarBookService;
	
	@GetMapping("grammarBookList")
	public ResponseEntity<?> getGrammarBookList(){
		try {
			return ResponseEntity.ok().body(grammarBookService.getGrammerBookList());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("grammarBook import falid");
		}
	}
	
}