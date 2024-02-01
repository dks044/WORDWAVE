package com.wordwave.grammar;

import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import com.wordwave.grammar.dto.GrammarExamplesDto;
import com.wordwave.grammar.dto.GrammarResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class GrammarServiceTest {
    @Autowired
    GrammarService grammarService;

    @Autowired
    GrammarRepository grammarRepository;

    @Test
    @DisplayName("Grammar id로 Grammar를 조회한다.")
    void getGrammarTest() {
        Long id = 16L;

        GrammarResponseDto grammarResponseDto = this.grammarService.getGrammar(id);

        System.out.println(grammarResponseDto.toString());
    }

    @Test
    @Rollback
    @DisplayName("Grammar id로 Grammar를 삭제한다.")
    void deleteGrammarTest() {
        long totalCountBefore = this.grammarRepository.count();
        Long id = 93L;

        this.grammarService.deleteGrammar(id);

        assertThat(this.grammarRepository.count()).isEqualTo(totalCountBefore - 1);
    }

    @Test
    @DisplayName("Grammar의 문장을 수정한다.")
    void updateSentenceTest() {
        Long id = 16L;
        String newSentence = "I _ Emma. I _ from New York.";
        ChangeSentenceDto changeSentenceDto = new ChangeSentenceDto(id, newSentence);

        this.grammarService.updateSentence(changeSentenceDto);

        assertThat(this.grammarRepository.findById(id).get().getSentence()).isEqualTo(newSentence);
    }

    @Test
    @DisplayName("Grammar의 보기를 저장한다.")
    void saveGrammarExampleTest() {
        Long grammarId = 16L;
        GrammarExampleDto grammarExampleDto1 = new GrammarExampleDto("am", true);
        GrammarExampleDto grammarExampleDto2 = new GrammarExampleDto("is", false);
        GrammarExampleDto grammarExampleDto3 = new GrammarExampleDto("are", false);
        GrammarExampleDto grammarExampleDto4 = new GrammarExampleDto("be", false);
        List<GrammarExampleDto> grammarExampleDtos = List.of(grammarExampleDto1, grammarExampleDto2, grammarExampleDto3, grammarExampleDto4);

        this.grammarService.saveGrammarExamples(new GrammarExamplesDto(grammarId, grammarExampleDtos));

        System.out.println(this.grammarService.getGrammar(grammarId));
    }
}