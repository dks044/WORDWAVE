package com.wordwave.grammarBook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.vocabook.VocaBookDTO;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/grammarbook")
@RequiredArgsConstructor
public class GrammarBookController {
	private final GrammarBookService grammarBookService;
	
	@GetMapping("grammarbook_List")
	public ResponseEntity<?> getGrammarBookList(){
		try {
			return ResponseEntity.ok().body(grammarBookService.getGrammerBookList());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("grammarBook import falid");
		}
	}
	
	@GetMapping("{grammarBookId}")
	public ResponseEntity<?> getGrammarBookDetail(@PathVariable("grammarBookId") long grammarBookId){
		try {
			GrammarBookDTO grammarBookDTO = grammarBookService.getCategoriesOfGrammarBook(grammarBookId);
			return ResponseEntity.ok().body(grammarBookDTO);
		} catch (Exception e) {	
			e.printStackTrace();
			return ResponseEntity.badRequest().body("GrammarBook 불러오기 실패!");
		}
	}
	
	
}
