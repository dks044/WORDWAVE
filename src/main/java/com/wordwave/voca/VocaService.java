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
	                    .imgURL(vocaDTO.getImgURL())
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
								.imgURL(v.getImgURL())
								.hiddenEngWord(createhiddenEngWord(v.getEngWord()))
								//.quizStatus((int)(Math.random()*2)+1) 임시로 주석처리
								.quizStatus(1)
								.build();
			vocaDTOs.add(vd);
		}
		Collections.shuffle(vocaDTOs);
		return vocaDTOs;
	}
	//영단어에 랜덤으로 언더바 삽입
	public String createhiddenEngWord(String engWord) {
		int wordLength = engWord.length();
		char[] word = engWord.toCharArray();
		StringBuilder parseHiddenWord = new StringBuilder();
		Set<Integer> random = new HashSet<>();
		if(wordLength <= 5) {
			while(random.size()<2) {
				random.add((int)(Math.random() * wordLength));
			}
		}else if(wordLength <= 8) {
			while(random.size()<=3) {
				random.add((int)(Math.random() * wordLength));
			}
		}else {
			while(random.size()<=4) {
				random.add((int)(Math.random() * wordLength));
			}
		}
		for(int i : random) word[i] = '_';
		for(char c : word) parseHiddenWord.append(c);
		return parseHiddenWord.toString();
	}
}
