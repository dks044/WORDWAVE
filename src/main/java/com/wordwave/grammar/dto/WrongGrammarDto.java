package com.wordwave.grammar.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class WrongGrammarDto {

    private String userName;

    private List<Long> wrongGrammarIds;

    private LocalDateTime lastAttempted;
}
