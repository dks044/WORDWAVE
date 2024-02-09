package com.wordwave.grammarbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrammarIdsOfGrammarBookDto {

    private Long id;

    private String name;

    private List<Long> grammarIds;
}
