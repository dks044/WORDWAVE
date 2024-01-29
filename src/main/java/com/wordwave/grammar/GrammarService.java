package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;

    public GrammarDto getGrammar(Long id) {
        Grammar grammar = getGrammarById(id);

        //GrammarExample --> GrammarExampleDto
        List<GrammarExampleDto> grammarExampleDtos = new ArrayList<>();
        for (GrammarExample grammarExample : grammar.getExamples()) {
            grammarExampleDtos.add(GrammarExampleDto.builder()
                    .example(grammarExample.getExample())
                    .isAnswer(grammarExample.getIsAnswer())
                    .build());
        }

        return GrammarDto.builder()
                .id(id)
                .sentence(grammar.getSentence())
                .grammarBookName(grammar.getGrammarBook().getName())
                .grammarExamples(grammarExampleDtos)
                .build();
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
