package com.wordwave.myvoca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wordwave.myvoca.dto.MyVocaCreateFormDTO;
import com.wordwave.myvoca.dto.MyVocaDTO;
import com.wordwave.myvoca.dto.MyVocaUpdateFormDTO;
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
	
	//업데이트폼에 활용
	public MyVocaUpdateFormDTO getMyVocaByMyVocaBookIdAndCategory(long myVocaBookId,String category) {
		MyVocaBook myVocaBook = myVocaBookService.getMyVocaBook(myVocaBookId);
		List<MyVoca> myVocas = myVocaBook.getMyVocas();
		List<MyVocaDTO> myVocaDTOs = new ArrayList<>();
		for(MyVoca mv : myVocas) {
			if(mv.getCategory().equals(category)) {
				myVocaDTOs.add(MyVocaDTO.builder().korWord(mv.getKorWord())
									.engWord(mv.getEngWord())
									.build());
			}
		}
		//해당 영어단어장에 없는 카테고리라면
		if(myVocaDTOs.size()==0)  throw new RuntimeException("이미 해당 영어단어장에 없는 카테고리입니다: " + category);
		return MyVocaUpdateFormDTO.builder().myVocaBookId(myVocaBookId)
											.category(category)
											.myVocas(myVocaDTOs)
											.build();
											
	}
}
