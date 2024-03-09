package com.wordwave.vocabook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wordwave.voca.VocaDTO;

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
	
	public List<VocaBookDTO> getVocaBookDTOList(){
		List<VocaBookDTO> vocaBookDTOList = new ArrayList<>();
		Map<Long,String> vocaBookNames = getVocaBookNameList();
		for(Map.Entry<Long,String> entry : vocaBookNames.entrySet()) {
			Long key = entry.getKey(); String value = entry.getValue();
			Optional<VocaBook> vocaBook = vocaBookRepository.findById(key);
			VocaBookDTO vb = VocaBookDTO.builder()
									    .id(key)
									    .name(value)
									    .imageURL(vocaBook.get().getImageURL())
									    .build();
			vocaBookDTOList.add(vb);
		}
		return vocaBookDTOList;
	}
	
	public VocaBookDTO getCategoriesOfVocaBook(long vocaBookId) {
	    List<String> categories = vocaBookRepository.findCategoriesByVocaBookId(vocaBookId);
	    Set<String> distinctCategories = new HashSet<>();
	    for(String category : categories) distinctCategories.add(category);
	    String name = vocaBookRepository.findById(vocaBookId).get().getName();
	    VocaBookDTO vocaBookDTO = VocaBookDTO.builder()
	    						.id(vocaBookId)
	    						.name(name)
	    						.categories(distinctCategories)
	    						.build();
	    return vocaBookDTO;
	}


}
