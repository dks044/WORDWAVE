package com.wordwave.myvoca;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.myvoca.dto.MyVocaCreateFormDTO;
import com.wordwave.util.ResponseDTO;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myvoca")
public class MyVocaController {
	private final MyVocaService myVocaService;

	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody MyVocaCreateFormDTO request){
		try {
			myVocaService.create(request);
			return ResponseEntity.ok().body("나만의 단어 생성 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(ResponseDTO.builder().data(e)
					 .error(e.getMessage())
					 .build().getError());
		}
	}
	
	//TODO: 퀴즈 기능 만들어놓기
}
