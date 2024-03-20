package com.wordwave.grammarBook;

import java.util.Optional;

import org.springframework.stereotype.Service;

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
	
}
