package com.wordwave.grammar;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammarbook.dto.GrammarNumOfGrammarBookDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GrammarRepositoryTest {

    @Autowired
    private GrammarRepository grammarRepository;

    @Test
    @DisplayName("EntityGraph로 GrammarExample만 join한다.")
    void findGrammarWithGrammarBookAndExampleByIdTest() {
        Long grammarId = 95L;

        Grammar grammar = this.grammarRepository.findGrammarWithGrammarExampleById(grammarId)
                .orElseThrow(() -> new DataNotFoundException("Grammar not found"));

        System.out.println(grammar);
    }

    @Test
    @DisplayName("GrammarBook의 id로 group by하여 개수를 센다.")
    void findNumOfAllGrammarBooksTest() {
        List<GrammarNumOfGrammarBookDto> grammarNumOfGrammarBookDtos = this.grammarRepository.findNumOfAllGrammarBooks();

        System.out.println(grammarNumOfGrammarBookDtos);
    }
}