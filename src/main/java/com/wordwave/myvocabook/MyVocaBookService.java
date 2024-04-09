package com.wordwave.myvocabook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wordwave.myvocabook.dto.MyVocaBookCategoriesDTO;
import com.wordwave.myvocabook.dto.MyVocaBookDTO;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyVocaBookService {
	private final MyVocaBookRepository myVocaBookRepository;
	private final UserService userService;
	
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
	
	
	public MyVocaBookCategoriesDTO getCategoriesOfMyVocaBook(long myVocaBookId) {
		List<String> categories = myVocaBookRepository.findCategoriesByMyVocaBookId(myVocaBookId);
		Set<String> distinctCategories = new HashSet<>();
		for(String category : categories) distinctCategories.add(category);
		String name = myVocaBookRepository.findById(myVocaBookId).get().getName();
		MyVocaBookCategoriesDTO myVocaBookCategoriesDTO = MyVocaBookCategoriesDTO.builder()
																				  .id(myVocaBookId)
																				  .name(name)
																				  .categories(distinctCategories)
																				  .build();
		return myVocaBookCategoriesDTO;
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
	
	public void delete(long myVocaBookId) {
	    Optional<MyVocaBook> validateMb = myVocaBookRepository.findById(myVocaBookId);
	    if(validateMb.isPresent()) { // Optional 객체의 존재 유무를 올바르게 확인
	        myVocaBookRepository.delete(validateMb.get());
	    } else {
	        throw new RuntimeException("유효하지 않은 myVocaBookId 입니다.");
	    }
	}

	
}
