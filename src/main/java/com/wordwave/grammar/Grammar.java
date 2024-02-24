package com.wordwave.grammar;

import com.wordwave.grammarbook.GrammarBook;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Grammar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sentence;

    @Column
    private String korean;

    @OneToMany(mappedBy = "grammar", cascade = CascadeType.ALL)
    private List<GrammarExample> examples = new ArrayList<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAMMAR_BOOK_ID")
    private GrammarBook grammarBook;

    @Builder
    public Grammar(String sentence, String korean, GrammarBook grammarBook) {
        this.sentence = sentence;
        this.korean = korean;
        this.grammarBook = grammarBook;
    }

    public void changeSentence(String newSentence) {
        this.sentence = newSentence;
    }

    @Override
    public String toString() {
        return "grammar id: " + this.id +
                ", sentence: " + this.sentence +
                ", korean: " + this.korean +
                ", book id: " + this.grammarBook.getId() +
                ", examples: " + this.examples;
    }
}
