package com.wordwave.vocabook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocaBookService {
	private final VocaBookRepository vocaBookRepository;
	
	public Map<Long,String> getVocaBookNameList(){
		Map<Long,String> vocaBookNames = new HashMap<>();
		List<VocaBook> vocaBookList = vocaBookRepository.findAll();
		for(VocaBook vb : vocaBookList) vocaBookNames.put(vb.getId(), vb.getName());
		return vocaBookNames;
	}
	
	public Map<Long,List<String>> getCategoriesOfVocaBook(long vocaBookId) {
	    Map<Long,List<String>> categoriesOfVocaBook = new HashMap<>();
	    categoriesOfVocaBook.put(vocaBookId, new ArrayList<String>());
	    List<String> categories = vocaBookRepository.findCategoriesByVocaBookId(vocaBookId);
	    Set<String> distinctCategories = new HashSet<>();
	    for(String category : categories) distinctCategories.add(category);
	    categoriesOfVocaBook.put(vocaBookId, new ArrayList<String>(distinctCategories));
	    return categoriesOfVocaBook;
	}

}
