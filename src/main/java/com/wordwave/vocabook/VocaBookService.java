package com.wordwave.vocabook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocaBookService {
	private final VocaBookRepository vocaBookRepository;
	
	public List<VocaBook> getVocaBookList(){
		return vocaBookRepository.findAll();
	}
	
	public Set<String> getCategoriesOfVocaBook(long vocaBookId) {
	    List<String> categories = vocaBookRepository.findCategoriesByVocaBookId(vocaBookId);
	    return new HashSet<>(categories);
	}

}
