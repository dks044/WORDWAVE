package com.wordwave.myvocabook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wordwave.aws.S3Service;
import com.wordwave.myvocabook.dto.MyVocaBookFormDTO;
import com.wordwave.security.TokenProvider;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;
import com.wordwave.util.ResponseDTO;

import groovy.util.logging.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/myvocabook")
@Tag(name = "MyVocaBook",description = "나만의 영어 단어장 관련 API")
public class MyVocaBookController {
	private final MyVocaBookService myVocaBookService;
	private final S3Service s3Service;
	private final UserService userService;
	//private static final String DEFAULT_IMAGE_URL = "https://cdn.pixabay.com/photo/2015/11/07/09/18/sunrise-1030600_1280.jpg"; 
	
	@Operation(
			summary = "나만의 영어단어장 전체 조회",
			description = "사용자가 생성만 '나만의 영어 단어장' 들을 전체적으로 조회한다."
			)
	@GetMapping("myVocaBookList/{userId}")
	public ResponseEntity<?> selectMyVocaBook(@PathVariable("userId") long userId){
		try {
			return ResponseEntity.ok().body(myVocaBookService.getMyVocaBookList(userId));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("myVocaBook import falid");
		}
	}
	
	@Operation(
			summary = "나만의 영어단어장 생성",
			description = "사용자가 '나만의 영어 단어장' 을 생성한다."
			)
	@PostMapping(value = "create", consumes = "multipart/form-data")
	public ResponseEntity<?> create(@RequestPart(value = "request") MyVocaBookFormDTO request,
									@RequestPart(value = "imageFile" ,required = false) MultipartFile imageFile){
		try {
			if(request == null || request.getName() == null) {
				throw new RuntimeException("empty name.");
			}
			SiteUser user = userService.getByUserId(request.getUserId());
			//이미지 파일이 없을경우
			if (imageFile == null || imageFile.isEmpty()) {
				MyVocaBook myVocaBook = MyVocaBook.builder()
						   .name(request.getName())
						   .user(user)
						   .build();
				myVocaBookService.create(myVocaBook);
			//이미지 파일이 있을경우	
			}else {
				MyVocaBook myVocaBook = MyVocaBook.builder()
						.name(request.getName())
						.imageURL(s3Service.saveFile(imageFile))
						.user(user)
						.build();
				myVocaBookService.create(myVocaBook);
			}
			return ResponseEntity.ok().body("myVocaBook 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity
								.badRequest()
								.body(responseDTO);
		}
	}
	
	@Operation(
			summary = "나만의 영어단어장 조회",
			description = "사용자가 생성 및 소유한 '나만의 영어 단어장' 조회한다."
			)
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
	@Operation(
			summary = "나만의 영어단어장 업데이트 폼 조회",
			description = "사용자의 '나만의 영어 단어장' 수정폼에 진입할 시, 원래 정보를 조회할수 있다."
			)
	@GetMapping("get/{myVocaBookId}/{userId}")
	public ResponseEntity<?> getMyVocaBook(@PathVariable("myVocaBookId") long myVocaBookId,
											@PathVariable("userId") long userId){
		try {
			return ResponseEntity.ok().body(myVocaBookService.getMyVocaBookById(myVocaBookId,userId));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("MyVocaBook 불러오기 실패!");
		}
	}
	@Operation(
			summary = "나만의 영어단어장 삭제",
			description = "사용자가 소유한 '나만의 영어 단어장' 삭제한다."
			)
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
	
	@Operation(
			summary = "나만의 영어단어장 수정",
			description = "사용자의 '나만의 영어 단어장'을 수정한다."
			)
	@PatchMapping(value = "patch/myVocaBook", consumes = "multipart/form-data")
	public ResponseEntity<?> patchMyVocaBook(@RequestPart(value = "request") MyVocaBookFormDTO request,
	                                         @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
	    try {
	        // 이미지 파일이 없을 경우
	        if (imageFile == null || imageFile.isEmpty()) {
	            myVocaBookService.update(request);
	        } else { // 이미지 파일이 존재할 경우
	            myVocaBookService.update(request, imageFile);
	        }
	        return ResponseEntity.ok().body(request.getMyVocaBookId() + " <= 수정완료");
	    } catch (Exception e) {
			e.printStackTrace();
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			return ResponseEntity
								.badRequest()
								.body(responseDTO);
	    }
	}
	
	
	//해당 MyVocaBook의 id가 해당 사용자의 소유가 맞는지 검증하는 api!!!!
	@Operation(
			summary = "나만의 영어단어장 검증",
			description = "해당 영어단어장이 해당 사용자의 소유가 맞는지 검증한다."
			)
	@GetMapping("validate/{myVocaBookId}/{userId}")
	public ResponseEntity<?> validateMyVocaBook(@PathVariable("myVocaBookId") long myVocaBookId,
												@PathVariable("userId") long userId){
		if(myVocaBookService.validateMyVocaBookId(myVocaBookId, userId)) {
			return ResponseEntity.ok().body("인증완료");
		}else {
			return ResponseEntity.status(500).body("인증실패!");
		}
	}
	
	

}
