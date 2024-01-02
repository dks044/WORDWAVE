package com.wordwave.grammar;

import lombok.Data;

@Data
public class GrammarDto {
    private String sentence;

    public GrammarDto(String sentence) {
        this.sentence = sentence;
    }
}
