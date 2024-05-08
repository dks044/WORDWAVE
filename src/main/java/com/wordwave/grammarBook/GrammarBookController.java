package com.wordwave.grammarBook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.vocabook.VocaBookDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/grammarbook")
@RequiredArgsConstructor
@Tag(name = "GrammarBook",description = "기본 영어 문법책 API")
public class GrammarBookController {
	private final GrammarBookService grammarBookService;
	
	@Operation(
			summary = "문법책 전체 조회",
			description = "사용자가 서버에 저장된 기본 영어 문법책들을 조회한다."
			)
	@GetMapping("grammarbook_List")
	public ResponseEntity<?> getGrammarBookList(){
		try {
			return ResponseEntity.ok().body(grammarBookService.getGrammerBookList());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("grammarBook import falid");
		}
	}
	
	@Operation(
			summary = "문법책 조회",
			description = "사용자가 서버에 저장된 특정 영어 문법책을 grammarBookId를 통해 조회한다."
			)
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
