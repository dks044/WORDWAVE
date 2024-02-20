package com.wordwave.grammar;

import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarChoiceDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import com.wordwave.grammar.dto.GrammarWriteDto;
import com.wordwave.grammarbook.dto.GrammarNumOfGrammarBookDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class GrammarServiceTest {
    @Autowired
    GrammarService grammarService;

    @Autowired
    GrammarRepository grammarRepository;

    @DisplayName("Grammar id로 GrammarBook의 id를 조회한다.")
    @ParameterizedTest
    @CsvSource({"108, 14", "91, 14", "1, "})
    void getGrammarBookIdByGrammarIdTest(Integer grammarIdInt, Integer grammarBookIdInt) {
        Long grammarId = (long) grammarIdInt;
        Long grammarBookId;
        if (grammarBookIdInt == null) {
            grammarBookId = null;
        } else {
            grammarBookId = (long) grammarBookIdInt;
        }


        Long response = this.grammarService.getGrammarBookIdByGrammarId(grammarId);

        assertThat(response).isEqualTo(grammarBookId);
    }

    @Test
    @DisplayName("grammarId로 Grammar와 그 grammarBook, grammarExample을 조회한다.")
    void getGrammarChoiceTest() {
        Long id = 108L;

        GrammarChoiceDto grammarChoiceDto = this.grammarService.getGrammarWithGrammarBookAndExampleById(id);

        System.out.println(grammarChoiceDto.toString());
    }

    @Test
    @DisplayName("grammarId로 Grammar의 sentence, korean을 조회한다.")
    void getGrammarWriteTest() {
        Long id = 155L;

        GrammarWriteDto grammarWriteDto = this.grammarService.getGrammarSentenceAndKoreanById(id);

        System.out.println(grammarWriteDto.toString());
    }

    @Test
    @DisplayName("모든 GrammarBook의 Grammar 개수를 조회한다.")
    void getGrammarNumOfAllGrammarBooksTest() {
        List<GrammarNumOfGrammarBookDto> grammarNumOfGrammarBookDtos = this.grammarService.getNumOfAllGrammarBooks();

        System.out.println(grammarNumOfGrammarBookDtos);
    }

    @DisplayName("Grammar와 GrammarExample을 함께 저장한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "조동사: I can _ a bike.: ride: true: riding: false: be riding: false",
            "조동사: Can you _ the guitar?: playing:false: play: true: be playing: false",
            "조동사: Sorry I'm late. I _ fast because the streets were icy.: could not walk: true: can't walk: false: could not walking: false",
    }, delimiter = ':')
    void saveGrammarAndGrammarExamplesTest(String grammarBoonName, String sentence,
                                           String ex1, boolean isAnswer1,
                                           String ex2, boolean isAnswer2,
                                           String ex3, boolean isAnswer3) {
        List<GrammarExampleDto> grammarExampleDtos = new ArrayList<>();
        grammarExampleDtos.add(GrammarExampleDto.builder()
                .example(ex1)
                .isAnswer(isAnswer1)
                .build());
        grammarExampleDtos.add(GrammarExampleDto.builder()
                .example(ex2)
                .isAnswer(isAnswer2)
                .build());
        grammarExampleDtos.add(GrammarExampleDto.builder()
                .example(ex3)
                .isAnswer(isAnswer3)
                .build());
        GrammarChoiceDto grammarChoiceDto = GrammarChoiceDto.builder()
                .grammarBookName(grammarBoonName)
                .sentence(sentence)
                .grammarExamples(grammarExampleDtos)
                .build();

        this.grammarService.saveGrammarAndGrammarExamples(grammarChoiceDto);
    }

    @Test
    @DisplayName("GrammarExample이 없는 Grammar를 저장한다.")
    void saveGrammarTest() {
        GrammarChoiceDto grammarChoiceDto = GrammarChoiceDto.builder()
                .grammarBookName("현재와 현재진행")
                .sentence("We _ busy. Let's watch a movie together")
                .build();

        Long grammarId = this.grammarService.saveGrammar(grammarChoiceDto).getId();

        System.out.println("============assert=============");
        System.out.println(grammarId);
    }

    @Test
    @DisplayName("이미 존재하는 Grammar에 GrammarExample을 저장한다.")
    void saveGrammarExampleTest() {
        Long grammarId = 153L;
        GrammarChoiceDto grammarChoiceDto = GrammarChoiceDto.builder()
                .id(grammarId)
                .grammarExamples(
                        List.of(
                                new GrammarExampleDto("Is, raining", false),
                                new GrammarExampleDto("Was, raining", true),
                                new GrammarExampleDto("Was, rain", false)
                        )
                )
                .build();

        this.grammarService.saveGrammarExamples(grammarChoiceDto);
    }

    @Test
    @Rollback
    @DisplayName("Grammar id로 Grammar를 삭제한다.")
    void deleteGrammarTest() {
        long totalCountBefore = this.grammarRepository.count();
        Long id = 93L;

        this.grammarService.deleteGrammar(id);

        assertThat(this.grammarRepository.count()).isEqualTo(totalCountBefore - 1);
    }

    @Test
    @DisplayName("Grammar의 문장을 수정한다.")
    void updateSentenceTest() {
        Long id = 16L;
        String newSentence = "I _ Emma. I _ from New York.";
        ChangeSentenceDto changeSentenceDto = new ChangeSentenceDto(id, newSentence);

        this.grammarService.updateSentence(changeSentenceDto);

        assertThat(this.grammarRepository.findById(id).get().getSentence()).isEqualTo(newSentence);
    }
}