package com.wordwave.grammar.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class WrongGrammarsResponseDto {

    private List<GrammarDto> wrongGrammars;

    private LocalDateTime lastTryTime;
}
