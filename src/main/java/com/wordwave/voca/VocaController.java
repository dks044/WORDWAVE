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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/voca")
@Tag(name = "Voca",description = "기본 영어 단어 관련 API")
public class VocaController {
	
	private final VocaService vocaService;
	
	@Operation(
			summary = "단어 퀴즈",
			description = "사용자가 단어 퀴즈를 수행할 수 있도록 클라이언트에 데이터를 전송한다."
			)
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
