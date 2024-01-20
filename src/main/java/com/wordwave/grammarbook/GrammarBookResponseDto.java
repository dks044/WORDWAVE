package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrammarBookResponseDto {

    private Long id;

    private String name;

    private List<GrammarResponseDto> grammars;
}
