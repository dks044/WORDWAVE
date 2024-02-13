package com.wordwave.grammarbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrammarNumOfGrammarBookDto {
    private Long id;

    private String name;

    private Long grammarNum;
}
