package com.wordwave.myvoca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wordwave.myvoca.dto.MyVocaCreateFormDTO;
import com.wordwave.myvoca.dto.MyVocaDTO;
import com.wordwave.myvocabook.MyVocaBook;
import com.wordwave.myvocabook.MyVocaBookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyVocaService {
	private final MyVocaRepository myVocaRepository;
	private final MyVocaBookService myVocaBookService;
	
	
	public void create(MyVocaCreateFormDTO myVocaCreateFormDTO) {
		MyVocaBook myVocaBook = myVocaBookService.getMyVocaBookIdAndUserId(myVocaCreateFormDTO.getMyVocaBookId(),
																			myVocaCreateFormDTO.getUserId());
		List<MyVoca> myVocas = myVocaBook.getMyVocas();
		List<MyVocaDTO> myVocaDTOs = myVocaCreateFormDTO.getMyVocas();
		for(MyVocaDTO mvDTO : myVocaDTOs) {
			MyVoca mv = MyVoca.builder()
							  .korWord(mvDTO.getKorWord())
							  .engWord(mvDTO.getEngWord())
							  .category(myVocaCreateFormDTO.getCategory())
							  .myVocaBook(myVocaBook)
							  .build();
			myVocas.add(mv);
		}
		myVocaBook.updateMyVocas(myVocas);
		myVocaBookService.create(myVocaBook);
	}
}
