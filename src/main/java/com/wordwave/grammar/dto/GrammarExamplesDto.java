package com.wordwave.grammar.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GrammarExamplesDto {

    private Long grammarId;

    private List<GrammarExampleDto> grammarExampleDtos;
}
