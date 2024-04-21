package com.wordwave.myvoca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wordwave.myvoca.dto.MyVocaCreateFormDTO;
import com.wordwave.myvoca.dto.MyVocaDTO;
import com.wordwave.myvoca.dto.MyVocaResponseDTO;
import com.wordwave.myvoca.dto.MyVocaUpdateFormDTO;
import com.wordwave.myvoca.dto.MyVocaUpdateFormRequestDTO;
import com.wordwave.myvocabook.MyVocaBook;
import com.wordwave.myvocabook.MyVocaBookService;
import com.wordwave.voca.Voca;

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
	//업데이트
	public void update(MyVocaUpdateFormRequestDTO requestDTO) {
	    MyVocaBook myVocaBook = myVocaBookService.getMyVocaBookIdAndUserId(requestDTO.getMyVocaBookId(),
	                                                                        requestDTO.getUserId());
	    List<MyVoca> myVocas = myVocaBook.getMyVocas();
	    List<MyVocaDTO> myVocaDTOs = requestDTO.getMyVocas();

	    // 이전 카테고리와 일치하는 단어들을 찾아서 삭제
	    Iterator<MyVoca> iterator = myVocas.iterator();
	    while (iterator.hasNext()) {
	        MyVoca mv = iterator.next();
	        if (mv.getCategory().equals(requestDTO.getPrevCategory())) {
	            iterator.remove(); // 메모리 상에서 삭제
	            myVocaRepository.delete(mv); // 데이터베이스에서도 삭제
	        }
	    }

	    //수정하는 카테고리가 이미 포함된 카테고리인지 검증한다
	    myVocaBookService.validateDistinctCategory(requestDTO.getMyVocaBookId(), requestDTO.getNextCategory());

	    for (MyVocaDTO mvDTO : myVocaDTOs) {
	        MyVoca mv = MyVoca.builder()
	                          .korWord(mvDTO.getKorWord())
	                          .engWord(mvDTO.getEngWord())
	                          .category(requestDTO.getNextCategory())
	                          .myVocaBook(myVocaBook)
	                          .build();
	        myVocas.add(mv); // 메모리 상에 추가
	    }
	    myVocaBook.updateMyVocas(myVocas); // 메모리 상의 변경 사항을 엔티티에 반영
	    myVocaBookService.create(myVocaBook); // 변경된 엔티티를 데이터베이스에 저장
	}
	
	public void delete(long myVocaBookId, long userId, String category) {
	    MyVocaBook myVocaBook = myVocaBookService.getMyVocaBookIdAndUserId(myVocaBookId, userId);
	    List<MyVoca> myVocas = myVocaBook.getMyVocas();
	    Iterator<MyVoca> iterator = myVocas.iterator();
	    while (iterator.hasNext()) {
	        MyVoca mv = iterator.next();
	        if (mv.getCategory().equals(category)) {
	            iterator.remove(); // 메모리 상에서 삭제
	            myVocaRepository.delete(mv); // 데이터베이스에서도 삭제
	        }
	    }
	    myVocaBook.updateMyVocas(myVocas); // 메모리 상의 변경 사항을 엔티티에 반영
	    myVocaBookService.create(myVocaBook); // 변경된 엔티티를 데이터베이스에 저장
	}
	
	//퀴즈
	public List<MyVocaResponseDTO> select(long myVocaBookId,long userId, String category){
		MyVocaBook mvb = myVocaBookService.getMyVocaBookIdAndUserId(myVocaBookId, userId);
		List<MyVoca> myVocas = myVocaRepository.findByMyVocaBookIdAndCategory(mvb.getId(), category);
		if(mvb == null || myVocas == null) {
			throw new RuntimeException("유효하지 않은 나만의 단어장("+myVocaBookId+") 과 사용자id("+userId+") 입니다.");
		}
		List<MyVocaResponseDTO> myVocaDTOs = new ArrayList<>();
		for(MyVoca mv : myVocas) {
			MyVocaResponseDTO mvr = MyVocaResponseDTO.builder()
													 .id(mv.getId())
													 .korWord(mv.getEngWord())
													 .engWord(mv.getEngWord())
													 .category(mv.getCategory())
													 .myVocaBookId(myVocaBookId)
													 .hiddenEngWord(createhiddenEngWord(mv.getEngWord()))
													 .quizStatus((int)(Math.random()*2)+1)
													 .randomEngWord(createRandomEngWord(myVocas, myVocaBookId, category, mv.getEngWord()))
													 .build();

			myVocaDTOs.add(mvr);
		}
		Collections.shuffle(myVocaDTOs);
		return myVocaDTOs;
	}
	
	//영단어에 랜덤으로 언더바 삽입
	//MEMO : 난이도 하향
	//TODO: 추후 난이도 알아서 조정
	private String createhiddenEngWord(String engWord) {
		int wordLength = engWord.length();
		char[] word = engWord.toCharArray();
		StringBuilder parseHiddenWord = new StringBuilder();
		Set<Integer> random = new HashSet<>();
		if(wordLength <= 5) {
			while(random.size()<2) {
				random.add((int)(Math.random() * wordLength));
			}
		}else {
			while(random.size()<=3) {
				random.add((int)(Math.random() * wordLength));
			}
		}
		for(int i : random) word[i] = '_';
		for(char c : word) parseHiddenWord.append(c);
		return parseHiddenWord.toString();
	}
	
	//랜덤 영단어 4개 (랜덤 영단어 4개 선택지 기능 구현 용도)
	private Set<String> createRandomEngWord(List<MyVoca> myVocas, long vocaBookId,String category,
			String engWord){
		Set<String> randomWord = new HashSet<>();
		randomWord.add(engWord); //원래 답 
		while(randomWord.size()<4) {
			randomWord.add(myVocas.get((int)(Math.random()*myVocas.size())).getEngWord());
		}
		
		return randomWord;
	}
}
