package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarDto;
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
//@TestPropertySource(locations = "classpath:application-test.properties")
class GrammarBookServiceTest {
    @Autowired
    GrammarBookService grammarBookService;

    @Test
    @DisplayName("GrammarBook id로 GrammarBook을 조회한다.")
    void getGrammarBookTest() {
        Long id = 6L;

        GrammarBookDto grammarBookDto = grammarBookService.getGrammarBookById(id);

        grammarBookDto.getGrammarDtos().forEach(grammarDto -> System.out.println(grammarDto.getSentence()));
        assertThat(grammarBookDto.getGrammarDtos().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("GrammarBook에 Grammar를 저장한다.")
    void saveGrammarTest() {
        String grammarBookName = "test book3";
        GrammarDto grammarDto1 = new GrammarDto("save grammar test3", grammarBookName);

        this.grammarBookService.saveGrammar(grammarDto1);
    }
}