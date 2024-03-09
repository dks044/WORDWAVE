package com.wordwave.grammar;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class GrammarExample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String example;

    @Column
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean isAnswer;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="GRAMMAR_ID")
    private Grammar grammar;

    @Builder
    public GrammarExample(String example, Boolean isAnswer, Grammar grammar) {
        this.example = example;
        this.isAnswer = isAnswer;
        this.grammar = grammar;
    }
}
