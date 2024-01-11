package com.wordwave.grammarbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
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
}