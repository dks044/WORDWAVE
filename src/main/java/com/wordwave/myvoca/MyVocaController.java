package com.wordwave.myvoca;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/myvoca")
@Tag(name = "MyVoca",description = "나만의 영어 단어장의 단어 관련 API")
public class MyVocaController {
	private final MyVocaService myVocaService;
	private final MyVocaBookService myVocaBookService;
	
	@Operation(
			summary = "사용자의 영어단어장에 단어",
			description = "사용자의 영어단어장에 단어를 생성 한다."
			)
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
	@Operation(
			summary = "사용자의 영어단어장의 단어 수정폼 정보",
			description = "사용자가 자신의 영어단어장에 할당된 단어를 수정할 시, 수정폼에 원래 정보가 조회 된다."
			)
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
	
	@Operation(
			summary = "사용자의 영어단어장의 단어 수정",
			description = "사용자가 자신의 영어 단어장에 할당된 단어를 수정폼에서 입력값을 통해 수정한다."
			)
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
	@Operation(
			summary = "사용자의 영어단어장의 단어 삭제",
			description = "사용자가 자신의 영어 단어장에 생성한 단어를 삭제한다."
			)
	@DeleteMapping("delete/{myVocaBookId}/{userId}/{category}")
	public ResponseEntity<?> deleteMyVoca(
											@PathVariable("myVocaBookId") long myVocaBookId,
											@PathVariable("userId") long userId,
											@PathVariable("category") String category){
		try {
			myVocaService.delete(myVocaBookId, userId, category);
			return ResponseEntity.ok().body("나만의 단어("+category+") 삭제 완료.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(ResponseDTO.builder().data(e)
					 .error(e.getMessage())
					 .build());
		}
	}
	
	//나만의 영단어 퀴즈
	@Operation(
			summary = "사용자의 영어단어장의 단어 퀴즈",
			description = "사용자가 자신의 영어 단어장에 할당된 단어를 통해 단어 퀴즈를 수행할 수 있도록 클라이언트에 데이터를 전송한다."
			)
	@GetMapping("{myVocaBookId}/{userId}/{category}")
	public ResponseEntity<?> select(@PathVariable("myVocaBookId")long myVocaBookId,
									@PathVariable("userId") long userId,
									@PathVariable("category") String category){
		try {
			return ResponseEntity.ok().body(myVocaService.select(myVocaBookId, userId, category));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(ResponseDTO.builder().data(e)
					 .error(e.getMessage())
					 .build());
		}
	}
	
}
