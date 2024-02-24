package com.wordwave.grammar;

import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
class GrammarControllerTest {
    @Autowired
    GrammarController grammarController;

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("grammar 조회 요청에 응답한다.")
    void getGrammarApiTest(boolean isChoice) {
        Long id = 16L;

        ResponseEntity<Object> response = this.grammarController.getGrammar(id, isChoice);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("각 GrammarBook마다 Grammar 개수 조회 요청에 응답한다.")
    void getGrammarNumOfAllGrammarBooksApiTest() {
        ResponseEntity<Object> response = this.grammarController.getGrammarNumOfAllGrammarBooks();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    @DisplayName("grammar와 grammarExample을 함께 저장하는 요청에 응답한다.")
    void saveGrammarExampleTest() {
        GrammarDto grammarDto = GrammarDto.builder()
                .sentence("This is test sentence.")
                .korean("이것은 테스트 문장입니다.")
                .grammarBookName("테스트북")
                .grammarExamples(List.of(
                        new GrammarExampleDto("is", true),
                        new GrammarExampleDto("are", false),
                        new GrammarExampleDto("am", false)
                ))
                .build();
        ResponseEntity<Object> response = this.grammarController.saveGrammarAndGrammarExamples(grammarDto);

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