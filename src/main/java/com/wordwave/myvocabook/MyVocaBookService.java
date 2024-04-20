package com.wordwave.myvocabook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wordwave.aws.S3Service;
import com.wordwave.myvoca.MyVoca;
import com.wordwave.myvocabook.dto.MyVocaBookCategoriesDTO;
import com.wordwave.myvocabook.dto.MyVocaBookDTO;
import com.wordwave.myvocabook.dto.MyVocaBookFormDTO;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;
import com.wordwave.util.UrlParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyVocaBookService {
	private final MyVocaBookRepository myVocaBookRepository;
	private final UserService userService;
	private final S3Service s3Service;
	private final UrlParser urlParser;
	
	public List<MyVocaBookDTO> getMyVocaBookList(long userId){
		SiteUser user = userService.getByUserId(userId);
		List<MyVocaBook> myVocaBook = myVocaBookRepository.findAllByUser(user);
		List<MyVocaBookDTO> response = new ArrayList<>();
		for(MyVocaBook mb : myVocaBook) {
			System.out.println(mb.getId());
			MyVocaBookDTO myVocaBookDTO = MyVocaBookDTO.builder()
													   .id(mb.getId())
													   .name(mb.getName())
													   .imageURL(mb.getImageURL())
													   .build();
			response.add(myVocaBookDTO);
		}
		
		return response;
	}
	
	public void create(MyVocaBook myVocaBook) {
		myVocaBookRepository.save(myVocaBook);
	}
	
	
	public MyVocaBookCategoriesDTO getCategoriesOfMyVocaBook(long myVocaBookId,long userId) {
		SiteUser user = userService.getByUserId(userId);
		MyVocaBook myVocaBook = myVocaBookRepository.findByIdAndUser(myVocaBookId, user);
		List<MyVoca> myVocas = myVocaBook.getMyVocas();
		Set<String> categories = new HashSet<>();
		for(MyVoca mv : myVocas) categories.add(mv.getCategory());
		return MyVocaBookCategoriesDTO.builder().id(myVocaBook.getId())
												.name(myVocaBook.getName())
												.categories(categories)
												.build();
	}
	
	
	public MyVocaBookDTO getMyVocaBookById(long myVocaBookId,long userId) {
		SiteUser user = userService.getByUserId(userId);
		MyVocaBook myVocaBook = myVocaBookRepository.findByIdAndUser(myVocaBookId, user);
		
		if(myVocaBook  != null) {
			MyVocaBookDTO mb = MyVocaBookDTO.builder()
											.id(myVocaBook.getId())
											.name(myVocaBook.getName())
											.imageURL(myVocaBook.getImageURL())
											.build();
			return mb;
		}else {
			throw new RuntimeException("유효하지 않은 myVocaBookId와 userId 입니다.");
		}
	}
	
	public MyVocaBook getMyVocaBook(long myVocaBookId) {
		Optional<MyVocaBook> validateMb = myVocaBookRepository.findById(myVocaBookId);
		if(validateMb.isPresent()) {
			return validateMb.get();
		}else throw new RuntimeException("유효하지 않은 myVocaBookId 입니다.");
	}
	
	//TODO: S3에 저장된 파일까지 삭제해야함.
	public void delete(long myVocaBookId) throws Exception {
	    Optional<MyVocaBook> validateMb = myVocaBookRepository.findById(myVocaBookId);
	    if(validateMb.isPresent()) { // Optional 객체의 존재 유무를 올바르게 확인
	    	String keyName = UrlParser.getKeyFromUrl(validateMb.get().getImageURL());
	    	s3Service.delete(keyName);
	        myVocaBookRepository.delete(validateMb.get());
	    } else {
	        throw new RuntimeException("유효하지 않은 myVocaBookId 입니다.");
	    }
	}

	//이름과 이미지파일까지 같이 수정할경우
	public void update(MyVocaBookFormDTO myVocaBookFormDTO ,MultipartFile imageFile) throws Exception {
		SiteUser user = userService.getByUserId(myVocaBookFormDTO.getUserId());
		MyVocaBook myVocaBook = myVocaBookRepository.findByIdAndUser(myVocaBookFormDTO.getMyVocaBookId(), user);
		String keyName = UrlParser.getKeyFromUrl(myVocaBook.getImageURL());
		s3Service.delete(keyName);
		myVocaBook.updateNameAndImageURL(myVocaBookFormDTO.getName(), s3Service.saveFile(imageFile));
		myVocaBookRepository.save(myVocaBook);
	}
	
	//이름만 수정할경우
	public void update(MyVocaBookFormDTO myVocaBookFormDTO) {
		SiteUser user = userService.getByUserId(myVocaBookFormDTO.getUserId());
		MyVocaBook myVocaBook = myVocaBookRepository.findByIdAndUser(myVocaBookFormDTO.getMyVocaBookId(), user);
		myVocaBook.updateName(myVocaBookFormDTO.getName());
		myVocaBookRepository.save(myVocaBook);
	}
	
	//해당 MyVocaBook의 id가 해당 사용자의 소유가 맞는지 검증한다.
	public boolean validateMyVocaBookId(long myVocaBookId,long userId) {
		Optional<MyVocaBook> myVocaBook = myVocaBookRepository.findById(myVocaBookId);
		if(myVocaBook.get().getUser().getId() != userId) {
			return false;
		}
		return true;
	}
	
	public MyVocaBook getMyVocaBookIdAndUserId(long myVocaBookId, long userId) {
		SiteUser user = userService.getByUserId(userId);
		return myVocaBookRepository.findByIdAndUser(myVocaBookId, user);
	}
}
