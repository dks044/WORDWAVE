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

    @OneToMany(mappedBy = "grammar", cascade = CascadeType.ALL)
    private List<GrammarExample> examples = new ArrayList<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "GRAMMAR_BOOK_ID")
    private GrammarBook grammarBook;

    @Builder
    public Grammar(String sentence, GrammarBook grammarBook) {
        this.sentence = sentence;
        this.grammarBook = grammarBook;
    }

    public void saveExamples(List<GrammarExample> grammarExamples) {
        this.examples = grammarExamples;
    }

    public void changeSentence(String newSentence) {
        this.sentence = newSentence;
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
