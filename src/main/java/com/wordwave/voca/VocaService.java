package com.wordwave.voca;


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

	
}
