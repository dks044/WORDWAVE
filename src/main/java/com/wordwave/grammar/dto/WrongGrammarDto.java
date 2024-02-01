package com.wordwave.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WrongGrammarDto {

    private String userName;

    private Long wrongGrammarId;

    private LocalDateTime lastAttempted;
}
