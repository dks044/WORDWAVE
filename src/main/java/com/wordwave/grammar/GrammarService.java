package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import com.wordwave.grammarbook.GrammarBook;
import com.wordwave.grammarbook.GrammarBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;
    private final GrammarBookRepository grammarBookRepository;
    private final GrammarExampleRepository grammarExampleRepository;

    public GrammarDto getGrammar(Long id) {
        Grammar grammar = getGrammarById(id);

        //GrammarExample --> GrammarExampleDto
        List<GrammarExampleDto> grammarExampleDtos = new ArrayList<>();
        for (GrammarExample grammarExample : grammar.getExamples()) {
            if (grammarExample != null) {
                grammarExampleDtos.add(GrammarExampleDto.builder()
                        .example(grammarExample.getExample())
                        .isAnswer(grammarExample.getIsAnswer())
                        .build());
            }
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

    /**
     * grammarBookName과 sentence가 담긴 DTO를 받아 GrammarExample이 없는 Grammar를 저장합니다.
     * 받아온 grammarBookName을 가진 GrammarBook이 존재하지 않는다면, 새로운 GrammarBook을 만듭니다.
     * */
    @Transactional
    public GrammarDto saveGrammar(GrammarDto grammarDto) {
        GrammarBook grammarBook = this.grammarBookRepository.findByName(grammarDto.getGrammarBookName())
                .orElseGet(() -> createGrammarBook(grammarDto.getGrammarBookName()));

        Grammar grammar = Grammar.builder()
                .sentence(grammarDto.getSentence())
                .grammarBook(grammarBook)
                .build();
        this.grammarRepository.save(grammar);
        return GrammarDto.builder()
                .id(grammar.getId())
                .build();
    }

    private GrammarBook createGrammarBook(String name) {
        return this.grammarBookRepository.save(GrammarBook.builder().name(name).build());
    }

    /**
     * Grammar의 id와 grammarExamples가 들어있는 DTO를 받아서
     * 이미 존재하는 Grammar에 GrammarExample을 저장합니다.
     * */
    @Transactional
    public void saveGrammarExamples(GrammarDto grammarDto) {
        Grammar grammar = getGrammarById(grammarDto.getId());
        if (grammarDto.getGrammarExamples() != null) {
            for (GrammarExampleDto grammarExampleDto : grammarDto.getGrammarExamples()) {
                GrammarExample grammarExample = GrammarExample.builder()
                        .example(grammarExampleDto.getExample())
                        .isAnswer(grammarExampleDto.getIsAnswer())
                        .grammar(grammar)
                        .build();
                this.grammarExampleRepository.save(grammarExample);
            }
        }
    }

    /**
     * grammarBookName, sentence, grammarExamples가 들어있는 DTO를 받아
     * Grammar와 GrammarExamples을 함께 저장합니다.
     * */
    @Transactional
    public void saveGrammarAndGrammarExamples(GrammarDto grammarDto) {
        GrammarDto grammarDtoOnlyId = saveGrammar(grammarDto);
        saveGrammarExamples(grammarDtoOnlyId);
    }

    private Grammar getGrammarById(Long id) {
        return this.grammarRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));
    }
}
