package com.wordwave.grammar.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GrammarDto {

    private Long id;

    private String sentence;

    private String korean;

    private List<GrammarExampleDto> grammarExamples;

    private String grammarBookName;
}
