package com.wordwave.grammarbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class GrammarBookRepositoryTest {
    @Autowired
    GrammarBookRepository grammarBookRepository;

    @Test
    @DisplayName("GrammarBook을 전체 조회한다.")
    void findAllTest() {
        System.out.println(this.grammarBookRepository.findAll());
    }

    @Test
    @DisplayName("GrammarBook에서 Grammar를 참조할때 null값이 포함되지 않는다.")
    void getGrammarsTest() {
        Long grammarBookId = 5L;

        GrammarBook grammarBook = this.grammarBookRepository.findById(grammarBookId).get();

        assertThat(grammarBook.getGrammars().size()).isEqualTo(10);
        System.out.println(grammarBook.getGrammars());
    }
}