package com.wordwave.grammar.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GrammarWriteDto {

    private Long id;

    private String sentence;

    private String korean;
}
