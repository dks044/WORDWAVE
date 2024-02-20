package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarChoiceDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import com.wordwave.grammar.dto.GrammarWriteDto;
import com.wordwave.grammarbook.GrammarBook;
import com.wordwave.grammarbook.GrammarBookRepository;
import com.wordwave.grammarbook.dto.GrammarNumOfGrammarBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;
    private final GrammarBookRepository grammarBookRepository;
    private final GrammarExampleRepository grammarExampleRepository;
    private final static String GRAMMAR_EXAMPLE_DELIMITER = ",";
    private final static String GRAMMAR_SENTENCE_BLANK = "_";

    public GrammarChoiceDto getGrammarWithGrammarBookAndExampleById(Long id) {
        Grammar grammar = this.grammarRepository.findGrammarWithGrammarExampleById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));

        return GrammarChoiceDto.builder()
                .id(id)
                .sentence(grammar.getSentence())
                .grammarBookName(grammar.getGrammarBook().getName())
                .grammarExamples(GrammarExampleToGrammarExampleDtoConverter.convert(grammar.getExamples()))
                .build();
    }

    public GrammarWriteDto getGrammarSentenceAndKoreanById(Long id) {
        Grammar grammar = this.grammarRepository.findGrammarWithGrammarExampleById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));

        GrammarExample grammarExample = grammar.getExamples().stream()
                .filter(GrammarExample::getIsAnswer)
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("GrammarExample not found"));

        String[] examples = grammarExample.getExample().split(GRAMMAR_EXAMPLE_DELIMITER);
        String sentence = grammar.getSentence();
        for (String ex : examples) {
            sentence = sentence.replaceFirst(GRAMMAR_SENTENCE_BLANK, ex.strip());
        }

        return GrammarWriteDto.builder()
                .id(id)
                .sentence(sentence)
                .korean(grammar.getKorean())
                .build();
    }

    public Long getGrammarBookIdByGrammarId(Long grammarId) {
        return this.grammarRepository.findGrammarBookIdByGrammarId(grammarId);
    }

    @Transactional(readOnly = true)
    public List<GrammarNumOfGrammarBookDto> getNumOfAllGrammarBooks() {
        return this.grammarRepository.findNumOfAllGrammarBooks();
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
    public GrammarChoiceDto saveGrammar(GrammarChoiceDto grammarChoiceDto) {
        GrammarBook grammarBook = this.grammarBookRepository.findByName(grammarChoiceDto.getGrammarBookName())
                .orElseGet(() -> createGrammarBook(grammarChoiceDto.getGrammarBookName()));

        Grammar grammar = Grammar.builder()
                .sentence(grammarChoiceDto.getSentence())
                .grammarBook(grammarBook)
                .build();
        this.grammarRepository.save(grammar);
        return GrammarChoiceDto.builder()
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
    public void saveGrammarExamples(GrammarChoiceDto grammarChoiceDto) {
        Grammar grammar = getGrammarById(grammarChoiceDto.getId());
        if (grammarChoiceDto.getGrammarExamples() != null) {
            for (GrammarExampleDto grammarExampleDto : grammarChoiceDto.getGrammarExamples()) {
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
    public void saveGrammarAndGrammarExamples(GrammarChoiceDto grammarChoiceDto) {
        Long grammarId = saveGrammar(grammarChoiceDto).getId();
        grammarChoiceDto.setId(grammarId);
        saveGrammarExamples(grammarChoiceDto);
    }

    private Grammar getGrammarById(Long id) {
        return this.grammarRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));
    }
}
