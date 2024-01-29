package com.wordwave.grammarbook;

import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import com.wordwave.grammarbook.dto.GrammarBookResponseDto;
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
    @DisplayName("GrammarBook id로 GrammarBook을 조회한다.")
    void getGrammarBookTest() {
        Long id = 12L;

        GrammarBookResponseDto grammarBookResponseDto = grammarBookService.getGrammarBook(id);

        System.out.println(grammarBookResponseDto.toString());
    }

    @Test
    @DisplayName("모든 GrammarBook의 이름을 조회한다.")
    void getAllGrammarBookNamesTest() {
        List<GrammarBookResponseDto> grammarBooks = this.grammarBookService.getAllGrammarBooksWithoutGrammar();

        System.out.println(grammarBooks);
    }

    @Test
    @DisplayName("GrammarBook에 Grammar를 저장한다.")
    void saveGrammarToGrammarBookTest() {
        String grammarBookName = "현재와 현재진행";
        GrammarDto grammarDto = GrammarDto.builder()
                .sentence("Paul and Emily _ singers. they are very famous")
                .grammarExamples(List.of(
                        new GrammarExampleDto("are", true),
                        new GrammarExampleDto("is", false),
                        new GrammarExampleDto("am", false)
                ))
                .grammarBookName(grammarBookName)
                .build();

        this.grammarBookService.saveGrammarToGrammarBook(grammarDto);

        System.out.println("===========assert===========");
        System.out.println(this.grammarBookRepository.findByName(grammarBookName));
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
        Long id = 12L;
        String newName = "test book4";

        this.grammarBookService.updateGrammarBookName(id, newName);

        assertTrue(this.grammarBookRepository.findByName(newName).isPresent());
    }
}