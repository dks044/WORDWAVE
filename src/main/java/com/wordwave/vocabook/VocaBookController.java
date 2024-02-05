package com.wordwave.vocabook;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groovy.util.logging.Log;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vocabook")
public class VocaBookController {
	private final VocaBookService vocaBookService;
	
	@GetMapping("view")
	public ResponseEntity<?> getVocaBookDetail(@RequestParam(value = "vocabook_id")long vocaBookId){
		try {
			Set<String> responseDTO = vocaBookService.getCategoriesOfVocaBook(vocaBookId);
			return ResponseEntity.ok().body(responseDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("VocaBook 불러오기 실패!");
		}
	}
	
		
	@GetMapping("vocabooklist")
	public ResponseEntity<?> selectVocaBook(){
		try {
			List<VocaBook> vocaBookList = vocaBookService.getVocaBookList();
			return ResponseEntity.ok().body(vocaBookList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("vocabook import falid");
		}
	}
	
}
