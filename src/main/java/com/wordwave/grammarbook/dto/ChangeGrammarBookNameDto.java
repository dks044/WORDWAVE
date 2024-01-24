package com.wordwave.grammarbook.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangeGrammarBookNameDto {

    private Long id;

    private String newName;
}
