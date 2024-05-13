package com.wordwave.voca;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.vocabook.VocaBook;
import com.wordwave.vocabook.VocaBookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class VocaService {
	
	private final VocaRepository vocaRepository;
	private final VocaBookRepository vocaBookRepository;
	//문자열 길이가 넘을경우
	private static final int OVER_FIVE = 2;
	private static final int OVER_EIGHT = 3;
	private static final int OVER_TEN = 4;
	
	public void create(VocaDTO vocaDTO,Long vocaBookId) {
		VocaBook vocaBook = vocaBookRepository.findById(vocaBookId)
				.orElseThrow(() -> new DataNotFoundException("vocaBook not found"));
	    Voca voca = Voca.builder()
	                    .korWord(vocaDTO.getKorWord())
	                    .engWord(vocaDTO.getEngWord())
	                    .category(vocaDTO.getCategory())
	                    .vocaBook(vocaBook)
	                    .build();
	    
	    
	    vocaRepository.save(voca);
	    vocaBook.getVocas().add(voca);
	    vocaBookRepository.save(vocaBook);
	}

	public List<VocaDTO> select(long vocaBookId, String category){
		List<Voca> vocas = vocaRepository.findByVocaBookIdAndCategory(vocaBookId, category);
		List<VocaDTO> vocaDTOs = new ArrayList<>();
		for(Voca v : vocas) {
			VocaDTO vd = VocaDTO.builder()
								.id(v.getId())
								.korWord(v.getKorWord())
								.engWord(v.getEngWord())
								.category(v.getCategory())
								.vocaBookId(v.getVocaBook().getId())
								.hiddenEngWord(createhiddenEngWord(v.getEngWord()))
								.quizStatus((int)(Math.random()*2)+1)
								.randomEngWord(createRandomEngWord(vocas,vocaBookId,category,v.getEngWord()))
								.build();
			vocaDTOs.add(vd);
		}
		Collections.shuffle(vocaDTOs);
		return vocaDTOs;
	}
	//영단어에 랜덤으로 언더바 삽입
	//MEMO : 난이도 하향
	//TODO: 추후 난이도 알아서 조정
	private String createhiddenEngWord(String engWord) {
		int wordLength = engWord.length();
		char[] word = engWord.toCharArray();
		StringBuilder parseHiddenWord = new StringBuilder();
		Set<Integer> random = new HashSet<>();
		if(wordLength <= 6) {
			while(random.size()<2) {
				random.add((int)(Math.random() * wordLength));
			}
		}else {
			while(random.size()<3) {
				random.add((int)(Math.random() * wordLength));
			}
		}
		for(int i : random) word[i] = '_';
		for(char c : word) parseHiddenWord.append(c);
		return parseHiddenWord.toString();
	}
	
	//랜덤 영단어 4개 (랜덤 영단어 4개 선택지 기능 구현 용도)
	private List<String> createRandomEngWord(List<Voca> vocas, long vocaBookId,String category,
			String engWord){
		List<String> randomWord = new ArrayList<>();
		randomWord.add(engWord); //원래 답 
		while(randomWord.size()<4) {
			String insertWord = vocas.get((int)(Math.random()*vocas.size())).getEngWord();
			if(!insertWord.equals(engWord)) randomWord.add(insertWord);			
		}
		
		return randomWord;
	}
	
	
}
