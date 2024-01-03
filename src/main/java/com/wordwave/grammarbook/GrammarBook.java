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

    @OneToMany(mappedBy = "grammarBook", cascade = CascadeType.PERSIST)
    private List<Grammar> grammars = new ArrayList<>();

    @Builder
    public GrammarBook(String name) {
        this.name = name;
    }
}
