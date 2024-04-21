package com.wordwave.myvoca;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordwave.myvoca.dto.MyVocaCreateFormDTO;
import com.wordwave.myvoca.dto.MyVocaUpdateFormRequestDTO;
import com.wordwave.myvocabook.MyVocaBookService;
import com.wordwave.util.ResponseDTO;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myvoca")
public class MyVocaController {
	private final MyVocaService myVocaService;
	private final MyVocaBookService myVocaBookService;
	
	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody MyVocaCreateFormDTO request){
		try {
			//해당 영어단어장에서 카테고리 중복 못하게
			myVocaBookService.validateDistinctCategory(request.getMyVocaBookId(), request.getCategory());
			myVocaService.create(request);
			return ResponseEntity.ok().body("나만의 단어 생성 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(ResponseDTO.builder().data(e)
					 .error(e.getMessage())
					 .build().getError());
		}
	}
	//업데이트 폼에 표시될 정보
	@GetMapping("updateForm/{myVocaBookId}/{category}")
	public ResponseEntity<?> updateForm(
												@PathVariable("myVocaBookId") long myVocaBookId,
												 @PathVariable("category") String category){
		try {
			return ResponseEntity.ok().body(myVocaService.getMyVocaByMyVocaBookIdAndCategory(myVocaBookId, category));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(ResponseDTO.builder().data(e)
					 .error(e.getMessage())
					 .build().getError());
		}
	}
	
	@PatchMapping("patch")
	public ResponseEntity<?> updateMyVoca(@RequestBody MyVocaUpdateFormRequestDTO request){
		try {
			myVocaService.update(request);
			return ResponseEntity.ok().body("나만의 단어("+request.getNextCategory()+") 수정완료.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(ResponseDTO.builder().data(e)
					 .error(e.getMessage())
					 .build().getError());
		}
	}
	
	//TODO: 퀴즈 기능 만들어놓기
}
