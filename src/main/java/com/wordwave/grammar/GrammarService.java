package com.wordwave.grammar;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrammarService {
	private final GrammarRepository grammarRepository;
	
	@Transactional
	public void create(GrammarDTO grammarDTO) {
		Grammar grammar = Grammar.builder()
								 .engSentence(grammarDTO.getEngSentence())
								 .originEngSentence(grammarDTO.getOriginEngSentence())
								 .korSentence(grammarDTO.getKorSentence())
								 .answer(grammarDTO.getAnswer())
								 .blackOptions(grammarDTO.getBlackOptions())
								 .category(grammarDTO.getCategory())
								 .grammarBook(grammarDTO.getGrammarBook())
								 .build();
		grammarRepository.save(grammar);
	}
	
}
