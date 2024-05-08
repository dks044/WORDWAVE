package com.wordwave.vocabook;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import groovy.util.logging.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vocabook")
@Tag(name = "VocaBook",description = "기본 영어 단어장 관련 API")
public class VocaBookController {
	private final VocaBookService vocaBookService;
	
		
	@Operation(
			summary = "기본 영어 단어장들 조회",
			description = "기본 영어 단어장들을 조회한다."
			)
	@GetMapping("vocabooklist")
	public ResponseEntity<?> selectVocaBook(){
		try {
			List<VocaBookDTO> responseDTO = vocaBookService.getVocaBookDTOList();
			return ResponseEntity.ok().body(responseDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("vocabook import falid");
		}
	}
	@Operation(
			summary = "기본 영어 단어장 조회",
			description = "vocaBookId를 통해 특정 '기본 영어 단어장'을 조회한다."
			)
	@GetMapping("{vocaBookId}")
	public ResponseEntity<?> getVocaBookDetail(@PathVariable("vocaBookId") long vocaBookId){
		try {
			VocaBookDTO vocaBook = vocaBookService.getCategoriesOfVocaBook(vocaBookId);
			return ResponseEntity.ok().body(vocaBook);
		} catch (Exception e) {	
			e.printStackTrace();
			return ResponseEntity.badRequest().body("VocaBook 불러오기 실패!");
		}
	}
	
	
}
