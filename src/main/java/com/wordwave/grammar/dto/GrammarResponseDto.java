package com.wordwave.grammar.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GrammarResponseDto {

    private Long id;

    private String sentence;

    private List<GrammarExampleDto> grammarExampleDtos;

    private String grammarBookName;
}
