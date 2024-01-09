package com.wordwave.grammar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class GrammarServiceTest {
    @Autowired
    GrammarService grammarService;

    @Autowired
    GrammarRepository grammarRepository;

    @Test
    @DisplayName("새로운 GrammarDto를 저장한다.")
    void grammarCreateTest() {
        String grammarBookName = "test book";
        GrammarDto grammarDto1 = new GrammarDto("Can you help me?", grammarBookName);
        GrammarDto grammarDto2 = new GrammarDto("I need some water.", grammarBookName);
        GrammarDto grammarDto3 = new GrammarDto("I think you've been starving for a few days", grammarBookName);

        grammarService.createGrammar(grammarDto1);
        grammarService.createGrammar(grammarDto2);
        grammarService.createGrammar(grammarDto3);
    }

    @Test
    @DisplayName("Grammar id로 Grammar를 조회한다.")
    void getGrammarTest() {
        Long id = 15L;

        GrammarDto grammarDto = this.grammarService.getGrammar(id);

        assertThat(grammarDto.getGrammarBookName()).isEqualTo("test book");
    }
}