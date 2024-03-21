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
		long id = 0;
		for(Grammar g : grammars) {
			GrammarDTO gDTO = GrammarDTO.builder()
										.id(id++)
										.engSentence(g.getEngSentence())
										.originEngSentence(g.getOriginEngSentence())
										.korSentence(g.getKorSentence())
										.answer(g.getAnswer())
										.blackOptions(g.getBlackOptions())
										.category(g.getCategory())
//										.quizStatus((int)(Math.random()*2)+1) 테스트를 위해 임시로 주석처리
										.quizStatus(2)
										.wordBlocks(wordBlocks(g.getOriginEngSentence()))
										.build();
			grammarsDTO.add(gDTO);
		}
		Collections.shuffle(grammarsDTO);
		return grammarsDTO;
	}
	
	//영어문장(originEngSentence)을 각 단어별로 분해한 리스트
	private List<String> wordBlocks(String originEngSentence){
		String[] words = originEngSentence.split(" ");
		List<String> wordBlock = new ArrayList<>();
		for(String word : words) wordBlock.add(word); 
		Collections.shuffle(wordBlock);
		return wordBlock;
	}
	
	
}
