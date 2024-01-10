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
        Long id = 42L;

        GrammarDto grammarDto = this.grammarService.getGrammar(id);

        System.out.println(grammarDto.getSentence());
    }

    @Test
    @DisplayName("Grammar id로 Grammar를 삭제한다.")
    void deleteGrammarTest() {
        long totalCountBefore = this.grammarRepository.count();
        Long id = 10L;

        this.grammarService.deleteGrammar(id);

        assertThat(this.grammarRepository.count()).isEqualTo(totalCountBefore-1);
    }
}