package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import com.wordwave.grammar.dto.GrammarExamplesDto;
import com.wordwave.grammar.dto.GrammarResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;

    public GrammarResponseDto getGrammar(Long id) {
        Grammar grammar = getGrammarById(id);
        GrammarResponseDto grammarResponseDto = new GrammarResponseDto();
        grammarResponseDto.setId(id);
        grammarResponseDto.setSentence(grammar.getSentence());
        grammarResponseDto.setGrammarBookName(grammar.getGrammarBook().getName());
        grammarResponseDto.setGrammarExampleDtos(grammar.getExamples().stream()
                .map(example -> new GrammarExampleDto(example.getExample(), example.getIsAnswer()))
                .toList());
        return grammarResponseDto;
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
    public void saveGrammarExamples(GrammarExamplesDto grammarExamplesDto) {
        Grammar grammar = getGrammarById(grammarExamplesDto.getGrammarId());
        grammar.saveExamples(grammarExamplesDto.getGrammarExampleDtos().stream()
                .map(dto -> new GrammarExample(dto.getExample(), dto.getIsAnswer(), grammar))
                .toList());
    }

    private Grammar getGrammarById(Long id) {
        return this.grammarRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));
    }
}
