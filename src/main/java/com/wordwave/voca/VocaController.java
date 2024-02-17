package com.wordwave.voca;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	private final VocaService vocaService;
	
	@GetMapping("/{vocaBookId}/{category}")
	public ResponseEntity<?> select(@PathVariable("vocaBookId") long vocaBookId,
									@PathVariable("category") String category
			){
		try {
			return ResponseEntity.ok().body(vocaService.select(vocaBookId, category));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("voca 불러오기 실패!");
		}
	}
	
}
