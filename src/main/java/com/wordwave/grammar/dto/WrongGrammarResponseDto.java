package com.wordwave.grammar.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WrongGrammarResponseDto {

    private Long grammarBookId;

    private LocalDateTime lastTryTime;
}
