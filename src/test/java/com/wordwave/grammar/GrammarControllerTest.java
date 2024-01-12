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
    @DisplayName("id로 grammar를 조회한다.")
    void getGrammarApiTest() {
        Long id = 16L;

        ResponseEntity<GrammarResponseDto> response = this.grammarController.getGrammar(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}