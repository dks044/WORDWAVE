package com.wordwave.myvocabook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/myvocabook")
public class MyVocaBookController {
	private final MyVocaBookService myVocaBookService;
	
	@GetMapping("myVocaBookList/{userId}")
	public ResponseEntity<?> selectMyVocaBook(@PathVariable("userId") long userId){
		try {
			return ResponseEntity.ok().body(myVocaBookService.getMyVocaBookList(userId));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("myVocaBook import falid");
		}
	}
	
}
