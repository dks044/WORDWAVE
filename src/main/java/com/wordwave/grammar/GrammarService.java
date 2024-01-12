package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammarbook.GrammarBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;
    private final GrammarBookRepository grammarBookRepository;

    public GrammarDto getGrammar(Long id) {
        Grammar grammar = getGrammarById(id);
        return new GrammarDto(grammar.getSentence(), grammar.getGrammarBook().getName());
    }

    public void deleteGrammar(Long id) {
        this.grammarRepository.deleteById(id);
    }

    @Transactional
    public void updateSentence(Long id, GrammarDto grammarDto) {
        Grammar grammar = getGrammarById(id);
        //MySQL 도입시 쿼리 성능 분석 필요
//        GrammarBook grammarBook = grammarBookRepository.findByName(grammarDto.getGrammarBookName())
//                        .orElseThrow(() -> new DataNotFoundException("Grammar book not found"));
        grammar.changeSentence(grammarDto.getSentence(), grammar.getGrammarBook().getGrammars());
    }

    private Grammar getGrammarById(Long id) {
        return this.grammarRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));
    }
}
