package com.wordwave.myvocabook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wordwave.aws.S3Service;
import com.wordwave.myvoca.MyVoca;
import com.wordwave.myvocabook.dto.MyVocaBookCategoriesDTO;
import com.wordwave.myvocabook.dto.MyVocaBookDTO;
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
	
	
	public MyVocaBookDTO getMyVocaBookById(long myVocaBookId) {
		Optional<MyVocaBook> validateMb = myVocaBookRepository.findById(myVocaBookId);
		
		if(validateMb != null) {
			MyVocaBookDTO mb = MyVocaBookDTO.builder()
											.id(validateMb.get().getId())
											.name(validateMb.get().getName())
											.imageURL(validateMb.get().getImageURL())
											.build();
			return mb;
		}else {
			throw new RuntimeException("유효하지 않은 myVocaBookId 입니다.");
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

	
}
