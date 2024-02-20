package com.wordwave.grammarbook;

import com.wordwave.grammarbook.dto.GrammarBookResponseDto;
import com.wordwave.grammarbook.dto.GrammarIdsOfGrammarBookDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @DisplayName("GrammarBook name으로 해당 GrammarBook의 GrammarId들을 조회한다.")
    void getGrammarBookTest() {
        for (int i = 0; i < 5; i++) {
            String grammarBookName = "조동사";

            GrammarIdsOfGrammarBookDto dto = grammarBookService.getGrammarIdsOfGrammarBook(grammarBookName);

            System.out.println(dto.toString());
        }
    }

    @Test
    @DisplayName("모든 GrammarBook의 id와 이름을 조회한다.")
    void getAllGrammarBookNamesTest() {
        List<GrammarBookResponseDto> grammarBooks = this.grammarBookService.getAllGrammarBooksWithoutGrammars();

        System.out.println(grammarBooks);
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
        Long id = 6L;
        String newName = "현재완료";

        this.grammarBookService.updateGrammarBookName(id, newName);

        assertTrue(this.grammarBookRepository.findByName(newName).isPresent());
    }
}