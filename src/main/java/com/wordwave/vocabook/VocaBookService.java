package com.wordwave.vocabook;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocaBookService {
	private final VocaBookRepository vocaBookRepository;
	
	public List<VocaBook> getVocaBookList(){
		return vocaBookRepository.findAll();
	}
	
}
