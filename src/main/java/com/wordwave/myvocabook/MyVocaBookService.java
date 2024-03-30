package com.wordwave.myvocabook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
			MyVocaBookDTO myVocaBookDTO = MyVocaBookDTO.builder()
													   .id(mb.getId())
													   .name(mb.getName())
													   .imageURL(mb.getImageURL())
													   .build();
			response.add(myVocaBookDTO);
		}
		
		return response;
	}
}
