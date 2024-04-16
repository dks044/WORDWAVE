package com.wordwave.myvocabook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wordwave.aws.S3Service;
import com.wordwave.myvocabook.dto.MyVocaBookFormDTO;
import com.wordwave.security.Key;
import com.wordwave.security.TokenProvider;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;
import com.wordwave.util.ResponseDTO;

import groovy.util.logging.Slf4j;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/myvocabook")
public class MyVocaBookController {
	private final MyVocaBookService myVocaBookService;
	private final S3Service s3Service;
	private final UserService userService;
	
	@GetMapping("myVocaBookList/{userId}")
	public ResponseEntity<?> selectMyVocaBook(@PathVariable("userId") long userId){
		try {
			return ResponseEntity.ok().body(myVocaBookService.getMyVocaBookList(userId));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("myVocaBook import falid");
		}
	}
	
	@PostMapping(value = "create", consumes = "multipart/form-data")
	public ResponseEntity<?> create(@RequestPart(value = "request") MyVocaBookFormDTO request,
									@RequestPart(value = "imageFile") MultipartFile imageFile){
		try {
			if(request == null || request.getName() == null) {
				throw new RuntimeException("empty name.");
			}
			SiteUser user = userService.getByUserId(request.getUserId());
			MyVocaBook myVocaBook = MyVocaBook.builder()
											   .name(request.getName())
											   .imageURL(s3Service.saveFile(imageFile))
											   .user(user)
											   .build();
			myVocaBookService.create(myVocaBook);
			return ResponseEntity.ok().body("myVocaBook 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity
								.badRequest()
								.body(responseDTO);
		}
	}
	
	@GetMapping("{myVocaBookId}/{userId}")
	public ResponseEntity<?> getMyVocaBookDetail(
												 @PathVariable("myVocaBookId") long myVocaBookId,
												 @PathVariable("userId") long userId
												 ){
		try {
			return ResponseEntity.ok().body(myVocaBookService.getCategoriesOfMyVocaBook(myVocaBookId, userId));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("MyVocaBook 불러오기 실패!");
		}
	}
	
	//myVocaBook 업데이트 폼 활용
	@GetMapping("get/{myVocaBookId}")
	public ResponseEntity<?> getMyVocaBook(@PathVariable("myVocaBookId") long myVocaBookId){
		try {
			return ResponseEntity.ok().body(myVocaBookService.getMyVocaBookById(myVocaBookId));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("MyVocaBook 불러오기 실패!");
		}
	}
	@DeleteMapping("delete/{myVocaBookId}")
	public ResponseEntity<?> deleteMyVocaBook(@PathVariable("myVocaBookId") long myVocaBookId){
		try {
			myVocaBookService.delete(myVocaBookId);
			
			return ResponseEntity.ok().body("해당 myVocaBook 제거 완료.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("MyVocaBook 삭제 실패!");
		}
	}
	
}
