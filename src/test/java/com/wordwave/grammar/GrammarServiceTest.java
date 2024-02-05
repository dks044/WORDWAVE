package com.wordwave.grammar;

import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
    @DisplayName("Grammar id로 Grammar를 조회한다.")
    void getGrammarTest() {
        Long id = 108L;

        GrammarDto grammarDto = this.grammarService.getGrammar(id);

        System.out.println(grammarDto.toString());
    }

    @Test
    @DisplayName("GrammarExample이 없는 Grammar를 저장한다.")
    void saveGrammarTest() {
        GrammarDto grammarDto = GrammarDto.builder()
                .grammarBookName("현재와 현재진행")
                .sentence("We _ busy. Let's watch a movie together")
                .build();

        Long grammarId = this.grammarService.saveGrammar(grammarDto).getId();

        System.out.println("============assert=============");
        System.out.println(grammarId);
    }

    @Test
    @DisplayName("이미 존재하는 Grammar에 GrammarExample을 저장한다.")
    void saveGrammarExampleTest() {
        Long grammarId = 110L;
        GrammarDto grammarDto = GrammarDto.builder()
                .id(grammarId)
                .grammarExamples(
                        List.of(
                                new GrammarExampleDto("is not allowed", false),
                                new GrammarExampleDto("not allowed", false),
                                new GrammarExampleDto("are not allowed", true)
                        )
                )
                .build();

        this.grammarService.saveGrammarExamples(grammarDto);
    }

    @Test
    @DisplayName("Grammar와 GrammarExample을 함께 저장한다.")
    void saveGrammarAndGrammarExamplesTest() {
        GrammarDto grammarDto = GrammarDto.builder()
                .grammarBookName("수동태")
                .sentence("Children _ in this pool.")
                .grammarExamples(
                        List.of(
                                new GrammarExampleDto("is not allowed", false),
                                new GrammarExampleDto("not allowed", false),
                                new GrammarExampleDto("are not allowed", true)
                        )
                )
                .build();

        this.grammarService.saveGrammarAndGrammarExamples(grammarDto);
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