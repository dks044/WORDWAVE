package com.wordwave.grammar.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangeSentenceDto {

    private Long id;

    private String newSentence;
}
