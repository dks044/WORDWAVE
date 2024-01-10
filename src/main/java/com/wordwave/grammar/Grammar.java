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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAMMAR_BOOK_ID")
    private GrammarBook grammarBook;

    @Builder
    public Grammar(String sentence, GrammarBook grammarBook) {
        this.sentence = sentence;
        this.grammarBook = grammarBook;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("grammar id: ").append(this.id)
                .append(", sentence: ").append(sentence)
                .append(", book name: ").append(this.grammarBook.getName())
                .toString();
    }
}
