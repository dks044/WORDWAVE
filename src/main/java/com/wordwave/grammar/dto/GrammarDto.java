package com.wordwave.grammar.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GrammarDto {

    private Long id;

    private String sentence;

    private List<GrammarExampleDto> grammarExamples;

    private String grammarBookName;
}
