package com.wordwave.grammar.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrammarChoiceDto {

    private Long id;

    private String sentence;

    private List<GrammarExampleDto> grammarExamples;

    private String grammarBookName;

    @Override
    public String toString() {
        return "id: " + id
                + ", sentence: " + sentence
                + ", grammarExamples: " + grammarExamples.toString()
                + ", grammarBookName: " + grammarBookName;
    }
}
