package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;

    public GrammarDto getGrammar(Long id) {
        Grammar grammar = getGrammarById(id);
        GrammarDto grammarDto = new GrammarDto();
        grammarDto.setId(id);
        grammarDto.setSentence(grammar.getSentence());
        grammarDto.setGrammarBookName(grammar.getGrammarBook().getName());
        grammarDto.setGrammarExamples(grammar.getExamples().stream()
                .map(example -> new GrammarExampleDto(example.getExample(), example.getIsAnswer()))
                .toList());
        return grammarDto;
    }

    public void deleteGrammar(Long id) {
        this.grammarRepository.deleteById(id);
    }

    @Transactional
    public void updateSentence(ChangeSentenceDto changeSentenceDto) {
        Grammar grammar = getGrammarById(changeSentenceDto.getId());
        grammar.changeSentence(changeSentenceDto.getNewSentence());
    }

    @Transactional
    public void saveGrammarExamples(GrammarDto grammarDto) {
        Grammar grammar = getGrammarById(grammarDto.getId());
        grammar.saveExamples(grammarDto.getGrammarExamples().stream()
                .map(dto -> new GrammarExample(dto.getExample(), dto.getIsAnswer(), grammar))
                .toList());
    }

    private Grammar getGrammarById(Long id) {
        return this.grammarRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));
    }
}
