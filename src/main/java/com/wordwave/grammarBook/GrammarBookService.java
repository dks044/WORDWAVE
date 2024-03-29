package com.wordwave.grammarBook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.wordwave.grammar.GrammarDTO;
import com.wordwave.vocabook.VocaBookDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrammarBookService {
	private final GrammarBookRepository grammarBookRepository;
	
	@Transactional
	public void create(GrammarBookDTO grammarBookDTO) {
		GrammarBook grammarBook = GrammarBook.builder()
											.name(grammarBookDTO.getName())
											.imageURL(grammarBookDTO.getImageURL())
											.build();
		grammarBookRepository.save(grammarBook);
	}
	
	@Transactional
	public GrammarBook getById(long id) {
		Optional<GrammarBook> grammarBook = grammarBookRepository.findById(id);
		if(grammarBook.isEmpty()) {
			throw new RuntimeException("grammarBook을 찾을 수 없습니다.");
		}else {
			return grammarBook.get();
		}
	}
	
	@Transactional
	public List<GrammarBookDTO> getGrammerBookList(){
		List<GrammarBook> grammarBooks = grammarBookRepository.findAll();
		List<GrammarBookDTO> grammarBookDTOs = new ArrayList<>();
		for(GrammarBook gb : grammarBooks) {
			GrammarBookDTO grammarBookDTO = GrammarBookDTO.builder()
														  .id(gb.getId())
														  .name(gb.getName())
														  .imageURL(gb.getImageURL())
														  .build();
			grammarBookDTOs.add(grammarBookDTO);
		}
		return grammarBookDTOs;
	}
	
	public GrammarBookDTO getCategoriesOfGrammarBook(long grammarBookId) {
	    List<String> categories = grammarBookRepository.findCategoriesByGrammarBookId(grammarBookId);
	    Set<String> distinctCategories = new HashSet<>();
	    for(String category : categories) distinctCategories.add(category);
	    String name = grammarBookRepository.findById(grammarBookId).get().getName();
	    GrammarBookDTO grammarBookDTO = GrammarBookDTO.builder()
	    						.id(grammarBookId)
	    						.name(name)
	    						.categories(distinctCategories)
	    						.build();
	    return grammarBookDTO;
	}
	

	
}
