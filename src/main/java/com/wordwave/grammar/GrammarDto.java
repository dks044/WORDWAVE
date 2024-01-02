package com.wordwave.grammar;

import lombok.Data;

@Data
public class GrammarDto {
    private String sentence;
    private String grammarBookName;

    public GrammarDto(String sentence, String grammarBookName) {
        this.sentence = sentence;
        this.grammarBookName = grammarBookName;
    }
}
