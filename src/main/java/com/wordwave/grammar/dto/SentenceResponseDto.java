package com.wordwave.grammar.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SentenceResponseDto {

    private Long id;

    private String sentence;
}
