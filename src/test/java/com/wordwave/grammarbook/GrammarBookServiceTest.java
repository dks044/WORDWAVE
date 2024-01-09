package com.wordwave.grammarbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
//@TestPropertySource(locations = "classpath:application-test.properties")
class GrammarBookServiceTest {
    @Autowired
    GrammarBookService grammarBookService;

    @Test
    @DisplayName("GrammarBook id로 GrammarBook을 조회한다.")
    void getGrammarBookTest() {
        Long id = 4L;

        GrammarBookDto grammarBookDto = grammarBookService.getGrammarBookById(id);

        assertThat(grammarBookDto.getGrammarDtos().size()).isEqualTo(6);
        grammarBookDto.getGrammarDtos().forEach(grammarDto -> System.out.println(grammarDto.getSentence()));
    }
}