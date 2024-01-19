package com.wordwave.grammar;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GrammarResponseDto {

    private Long id;

    private String sentence;

    private String grammarBookName;
}
