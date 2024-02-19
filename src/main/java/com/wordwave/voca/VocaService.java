package com.wordwave.voca;


import java.util.ArrayList;
import java.util.Collections;
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
								.build();
			vocaDTOs.add(vd);
		}
		Collections.shuffle(vocaDTOs);
		return vocaDTOs;
	}
}
