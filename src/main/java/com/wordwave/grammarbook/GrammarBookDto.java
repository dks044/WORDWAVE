package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarDto;
import lombok.Data;

import java.util.List;

@Data
public class GrammarBookDto {

    private String name;

    private List<GrammarDto> grammarDtos;
}
