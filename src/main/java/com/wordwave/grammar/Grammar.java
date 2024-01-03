package com.wordwave.grammar;

import com.wordwave.grammarbook.GrammarBook;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Grammar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sentence;

    @ManyToOne(optional = false)
    @JoinColumn(name = "GRAMMAR_BOOK_ID")
    private GrammarBook grammarBook;

    @Builder
    public Grammar(String sentence, GrammarBook grammarBook) {
        this.sentence = sentence;
        this.grammarBook = grammarBook;
    }
}
