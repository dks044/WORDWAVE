package com.wordwave.grammarbook;

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
