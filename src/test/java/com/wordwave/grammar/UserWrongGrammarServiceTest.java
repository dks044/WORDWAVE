package com.wordwave.grammar;

import com.wordwave.grammar.dto.WrongGrammarsDto;
import com.wordwave.grammar.dto.WrongGrammarsResponseDto;
import com.wordwave.grammarbook.dto.GrammarIdsOfGrammarBookDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserWrongGrammarServiceTest {
    @Autowired
    UserWrongGrammarService userWrongGrammarService;

    @DisplayName("사용자가 틀린 문법 퀴즈들을 조회한다.")
    @Test
    void getUserWrongGrammarsTest() {
        String userName = "jjy1234";
        int max = 1;
        int cnt = 0;
        int meanTime = 0;
        while (cnt < max) {
            long beforeTime = System.currentTimeMillis();
            WrongGrammarsResponseDto response = this.userWrongGrammarService.getUserWrongGrammars(userName);
            long afterTime = System.currentTimeMillis();
            meanTime += (int) (afterTime - beforeTime);
            System.out.println(response);
            cnt++;
        }
        System.out.println("평균 실행 시간(ms): " + (meanTime / max));
    }

    @Test
    @DisplayName("특정 grammarBook 중 사용자가 틀린 grammar만 조회한다.")
    void getUserWrongGrammarBookTest() {
        String userName = "jjy1234";
        String grammarBookName = "현재와 현재진행";

        GrammarIdsOfGrammarBookDto grammarBookResponseDto = this.userWrongGrammarService.getUserWrongGrammarBook(userName, grammarBookName);

        System.out.println(grammarBookResponseDto);
    }

    @Test
    @DisplayName("사용자가 틀린 문법 퀴즈들을 저장한다. grammarBook이 없는 grammarId를 저장하려하면 grammarBookId에 null이 저장된다.")
    @Rollback
    void saveUserWrongGrammarsTest() {
        WrongGrammarsDto wrongGrammarsDto = WrongGrammarsDto.builder()
                .userName("jjy1234")
                .wrongGrammarIds(List.of(91L, 95L, 108L))
                .grammarBookName("현재와 현재진행")
                .lastTryTime(LocalDateTime.now())
                .build();

        this.userWrongGrammarService.saveUserWrongGrammars(wrongGrammarsDto);
    }

    @Test
    @DisplayName("사용자가 마지막으로 풀이를 시도했던 시간을 수정한다.")
    void updateUserLastTryTimeTest() {
        WrongGrammarsDto wrongGrammarsDto = WrongGrammarsDto.builder()
                .userName("jjy1234")
                .wrongGrammarIds(List.of(42L, 43L, 44L))
                .lastTryTime(LocalDateTime.now())
                .build();

        this.userWrongGrammarService.updateUserLastTryTime(wrongGrammarsDto);
    }

    @Test
    @DisplayName("사용자가 틀렸던 문법 퀴즈들을 삭제한다.")
    void deleteUserWrongGrammarsTest() {
        WrongGrammarsDto wrongGrammarsDto = WrongGrammarsDto.builder()
                .userName("jjy1234")
                .wrongGrammarIds(List.of(42L))
                .build();

        this.userWrongGrammarService.deleteUserWrongGrammars(wrongGrammarsDto);
    }
}