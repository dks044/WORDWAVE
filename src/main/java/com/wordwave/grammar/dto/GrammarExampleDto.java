package com.wordwave.grammar.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GrammarExampleDto {

    private String example;

    private Boolean isAnswer;
}
