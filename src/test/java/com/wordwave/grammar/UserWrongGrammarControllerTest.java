package com.wordwave.grammar;

import com.wordwave.grammar.dto.WrongGrammarsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserWrongGrammarControllerTest {
    @Autowired
    UserWrongGrammarController userWrongGrammarController;

    private void mockLogin() {
        // 인증 객체 생성
        UserDetails userDetails = new User("jjy1234", "Rbu0eEOP", new ArrayList<>());
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        // SecurityContext에 인증 객체 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @DisplayName("사용자가 틀린 문법 문제들을 조회하는 요청에 대해 응답한다.")
    @ParameterizedTest
    @CsvSource({"'jjy1234', 200", "'', 404", ", 404"})
    void getUserWrongGrammarsApiTest(String userName, int statusCode) {
        mockLogin();

        ResponseEntity<?> response = this.userWrongGrammarController.getUserWrongGrammars(userName);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(statusCode));
    }

    @DisplayName("특정 문법 책(유형) 중 사용자가 틀린 문법 문제들만 조회하는 요청에 응답한다.")
    @Test
    void getUserWrongGrammarBookAPITest() {
        String userName = "jjy1234";
        String grammarBookName = "현재와 현재진행";

        ResponseEntity<?> response = this.userWrongGrammarController.getUserWrongGrammarBook(userName, grammarBookName);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @DisplayName("사용자가 틀린 문법 문제들을 저장하는 요청에 대해 응답한다.")
    @Test
    @Rollback(false)
    void saveUserWrongGrammarsApiTest() {
        mockLogin();

        ResponseEntity<?> response = this.userWrongGrammarController.saveUserWrongGrammars(WrongGrammarsDto.builder()
                .userName("jjy1234")
                .wrongGrammarIds(List.of(1L, 2L))
                .build());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @DisplayName("사용자가 마지막으로 다시 푼 시각을 수정한다.")
    @Test
    void updateUserLastTryTimeApiTest() {
        mockLogin();

        ResponseEntity<?> response = this.userWrongGrammarController.updateUserLastTryTime(
                WrongGrammarsDto.builder()
                        .userName("jjy1234")
                        .wrongGrammarIds(List.of(42L, 43L, 44L))
                        .lastTryTime(LocalDateTime.now())
                        .build()
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @DisplayName("사용자가 틀렸던 문법 문제들을 삭제하는 요청에 응답한다.")
    @Test
    void deleteUserWrongGrammarsApiTest() {
        mockLogin();

        ResponseEntity<?> response = this.userWrongGrammarController.deleteUserWrongGrammars(
                WrongGrammarsDto.builder()
                        .userName("jjy1234")
                        .wrongGrammarIds(List.of(1L, 2L))
                        .build()
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }
}