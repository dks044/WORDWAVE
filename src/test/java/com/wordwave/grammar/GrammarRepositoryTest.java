package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GrammarRepositoryTest {

    @Autowired
    private GrammarRepository grammarRepository;

    @Test
    @DisplayName("EntityGraph로 이중 join을 할 수 있다.")
    void findGrammarWithGrammarBookAndExampleByIdTest() {
        Long grammarId = 95L;

        Grammar grammar = this.grammarRepository.findGrammarWithGrammarBookAndExampleById(grammarId)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));

        System.out.println(grammar);
    }
}