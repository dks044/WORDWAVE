package com.wordwave.grammar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class GrammarControllerTest {
    @Autowired
    GrammarController grammarController;

    @Test
    @DisplayName("grammar 조회 요청에 응답한다.")
    void getGrammarApiTest() {
        Long id = 16L;

        ResponseEntity<GrammarResponseDto> response = this.grammarController.getGrammar(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("해당 grammar의 sentence 수정 요청에 응답한다.")
    void updateSentenceApiTest() {
        Long id = 16L;
        GrammarDto grammarDto = new GrammarDto("update api test 1", "test book1");

        ResponseEntity<Object> response = this.grammarController.updateSentence(id, grammarDto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}