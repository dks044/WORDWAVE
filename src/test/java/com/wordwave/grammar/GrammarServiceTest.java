package com.wordwave.grammar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class GrammarServiceTest {
    @Autowired
    GrammarService grammarService;

    @Autowired
    GrammarRepository grammarRepository;

    @Test
    @DisplayName("Grammar id로 Grammar를 조회한다.")
    void getGrammarTest() {
        Long id = 16L;

        GrammarResponseDto grammarResponseDto = this.grammarService.getGrammar(id);

        System.out.println(grammarResponseDto.getSentence());
    }

    @Test
    @DisplayName("Grammar id로 Grammar를 삭제한다.")
    void deleteGrammarTest() {
        long totalCountBefore = this.grammarRepository.count();
        Long id = 10L;

        this.grammarService.deleteGrammar(id);

        assertThat(this.grammarRepository.count()).isEqualTo(totalCountBefore - 1);
    }

    @Test
    @DisplayName("Grammar의 문장을 수정한다.")
    void updateSentenceTest() {
        Long id = 16L;
        String newSentence = "update sentence test 4";
        GrammarDto grammarDto = new GrammarDto(newSentence, "test book1");

        this.grammarService.updateSentence(id, grammarDto);

        assertThat(this.grammarRepository.findById(id).get().getSentence()).isEqualTo(newSentence);
    }
}