package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class GrammarBookResponseDto {

    private Long id;

    private String name;

    private List<GrammarResponseDto> grammars;
}
