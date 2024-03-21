package com.wordwave.grammar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	
	public List<GrammarDTO> select(long grammarBookId, String category){
		List<Grammar> grammars = grammarRepository.findByGrammarBookIdAndCategory(grammarBookId, category);
		List<GrammarDTO> grammarsDTO = new ArrayList<>();
		for(Grammar g : grammars) {
			GrammarDTO gDTO = GrammarDTO.builder()
										.engSentence(g.getEngSentence())
										.originEngSentence(g.getOriginEngSentence())
										.korSentence(g.getKorSentence())
										.answer(g.getAnswer())
										.blackOptions(g.getBlackOptions())
										.category(g.getCategory())
										.build();
			grammarsDTO.add(gDTO);
		}
		Collections.shuffle(grammarsDTO);
		return grammarsDTO;
	}
	
	
	
	
}
