package com.wordwave.voca.data;


import org.springframework.stereotype.Service;

import com.wordwave.voca.VocaDTO;
import com.wordwave.voca.VocaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class VocaDataTool {
	private final VocaService vocaService;
	
	public void insertVocaByString(String[] vocaData,long vocaBookId,String category) {
		for(String sentence : vocaData) {
			String[] word = sentence.split("\\|");
			VocaDTO voca = VocaDTO.builder()
					.engWord(word[0].trim())
					.korWord(word[1].trim())
					.category(category)
					.build();
			vocaService.create(voca, vocaBookId);
		}
	}
	
	
	
}
