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
import lombok.RequiredArgsConstructor;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vocabook")
public class VocaBookController {
	private final VocaBookService vocaBookService;
	
		
		
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
	
	@GetMapping("{vocaBookId}")
	public ResponseEntity<?> getVocaBookDetail(@PathVariable("vocaBookId") long vocaBookId){
		try {
			Map<Long,List<String>> categories = vocaBookService.getCategoriesOfVocaBook(vocaBookId);
			return ResponseEntity.ok().body(categories);
		} catch (Exception e) {	
			e.printStackTrace();
			return ResponseEntity.badRequest().body("VocaBook 불러오기 실패!");
		}
	}
	
}
