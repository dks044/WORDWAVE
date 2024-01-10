package com.wordwave.grammarbook;

import com.wordwave.grammar.Grammar;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor
public class GrammarBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @ColumnDefault(value = "'일반'")
    private String name;

    @OneToMany(mappedBy = "grammarBook", cascade = CascadeType.ALL)
    private List<Grammar> grammars = new ArrayList<>();

    @Builder
    public GrammarBook(String name) {
        this.name = name;
    }

    public void addGrammar(Grammar grammar) {
        this.grammars.add(grammar);
    }

    public void changeName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("grammarBook id: ").append(this.id)
                .append(", name: ").append(this.name)
                .append(", grammars: ").append(this.grammars)
                .toString();
    }
}
