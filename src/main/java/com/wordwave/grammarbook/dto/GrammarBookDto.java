package com.wordwave.grammarbook.dto;

import com.wordwave.grammar.dto.GrammarDto;
import lombok.Data;

import java.util.List;

@Data
public class GrammarBookDto {

    private String name;

    private List<GrammarDto> grammarDtos;
}
