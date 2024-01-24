package com.wordwave.grammar;

import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarResponseDto;
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
        String newSentence = "I _ Emma. I _ from New York.";
        ChangeSentenceDto changeSentenceDto = new ChangeSentenceDto(id, newSentence);

        ResponseEntity<Object> response = this.grammarController.updateSentence(changeSentenceDto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("해당 grammar 삭제 요청에 응답한다.")
    @Rollback
    void deleteGrammarApiTest() {
        Long id = 16L;

        ResponseEntity<Object> response = this.grammarController.deleteGrammar(id);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}