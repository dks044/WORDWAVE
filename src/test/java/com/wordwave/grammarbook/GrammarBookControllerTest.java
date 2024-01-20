package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //내가 설정한 값대로 DB 사용
class GrammarBookControllerTest {
    @Autowired
    GrammarBookController grammarBookController;

    @Test
    @DisplayName("GrammarBook 조회 요청에 대해 응답한다.")
    void getGrammarBookApiTest() {
        Long id = 5L;

        ResponseEntity<GrammarBookResponseDto> response = this.grammarBookController.getGrammarBook(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("전체 GrammarBook 조회 요청에 대해 응답한다.")
    void getAllGrammarBookApiTest() {
        ResponseEntity<List<GrammarBookResponseDto>> response = this.grammarBookController.getAllGrammarBooks();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("Grammar 저장 요청을 받고 저장한다.")
    void saveGrammarApiTest() {
        GrammarDto grammarDto = new GrammarDto("save api test", "test book3");

        ResponseEntity<Object> response = this.grammarBookController.saveGrammar(grammarDto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("GrammarBook의 이름 수정 요청을 받고 수정한다.")
    @Rollback
    void updateGrammarBookNameTest() {
        ChangeGrammarBookNameDto changeGrammarBookNameDto = new ChangeGrammarBookNameDto(6L, "test book2");

        ResponseEntity<Object> response = this.grammarBookController.updateGrammarBookName(changeGrammarBookNameDto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("GrammarBook을 삭제 요청을 받고 삭제한다.")
    @Rollback
    void deleteGrammarBookTest() {
        Long id = 6L;

        ResponseEntity<Object> response = this.grammarBookController.deleteGrammarBook(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}