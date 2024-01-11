package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@Rollback(false)
class GrammarBookServiceTest {
    @Autowired
    GrammarBookService grammarBookService;

    @Autowired
    GrammarBookRepository grammarBookRepository;

    @Test
    @DisplayName("GrammarBook id로 GrammarBook을 조회한다.")
    void getGrammarBookTest() {
        Long id = 5L;

        GrammarBookResponseDto grammarBookResponseDto = grammarBookService.getGrammarBook(id);

        System.out.println(grammarBookResponseDto.toString());
        assertThat(grammarBookResponseDto.getGrammarDtos().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("GrammarBook에 Grammar를 저장한다.")
    void saveGrammarTest() {
        String grammarBookName = "test book3";
        GrammarDto grammarDto1 = new GrammarDto("save grammar test3", grammarBookName);

        this.grammarBookService.saveGrammar(grammarDto1);
    }

    @Test
    @DisplayName("GrammarBook을 삭제한다.")
    @Rollback
    void deleteGrammarBookTest() {
        long totalCountBefore = this.grammarBookRepository.count();
        Long id = 6L;

        this.grammarBookService.deleteGrammarBook(id);

        assertThat(grammarBookRepository.count()).isEqualTo(totalCountBefore-1);
    }

    @Test
    @DisplayName("GrammarBook의 이름을 수정한다.")
    void updateGrammarBookNameTest() {
        Long id = 5L;
        String newName = "test book1";

        this.grammarBookService.updateGrammarBookName(id, newName);

        assertTrue(this.grammarBookRepository.findByName(newName).isPresent());
    }
}