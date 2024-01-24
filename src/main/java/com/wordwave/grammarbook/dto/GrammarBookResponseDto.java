package com.wordwave.grammarbook.dto;

import com.wordwave.grammar.dto.SentenceResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrammarBookResponseDto {

    private Long id;

    private String grammarBookName;

    private List<SentenceResponseDto> grammars;
}
