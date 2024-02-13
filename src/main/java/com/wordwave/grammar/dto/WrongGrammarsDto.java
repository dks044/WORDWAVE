package com.wordwave.grammar.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class WrongGrammarsDto {

    private String userName;

    private String grammarBookName;

    private List<Long> wrongGrammarIds;

    private LocalDateTime lastTryTime;
}
