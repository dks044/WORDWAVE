package com.wordwave.grammar;

import com.wordwave.grammar.dto.GrammarExampleDto;

import java.util.ArrayList;
import java.util.List;

public class GrammarExampleToGrammarExampleDtoConverter {
    public static List<GrammarExampleDto> convert(List<GrammarExample> grammarExamples) {
        List<GrammarExampleDto> grammarExampleDtos = new ArrayList<>();
        for (GrammarExample grammarExample : grammarExamples) {
            if(grammarExample != null) {
                grammarExampleDtos.add(GrammarExampleDto.builder()
                        .example(grammarExample.getExample())
                        .isAnswer(grammarExample.getIsAnswer())
                        .build());
            }
        }
        return grammarExampleDtos;
    }
}
