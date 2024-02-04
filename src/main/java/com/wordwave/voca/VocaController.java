package com.wordwave.voca;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.vocabook.VocaBook;
import com.wordwave.vocabook.VocaBookService;

import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/voca")
public class VocaController {
	
	private final VocaBookService vocaBookService;
	
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
