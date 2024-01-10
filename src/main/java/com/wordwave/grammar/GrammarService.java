package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;

    public GrammarDto getGrammar(Long id) {
        Grammar grammar = this.grammarRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found."));
        return new GrammarDto(grammar.getSentence(), grammar.getGrammarBook().getName());
    }

    public void deleteGrammar(Long id) {
        this.grammarRepository.deleteById(id);
    }
}
