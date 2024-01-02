package com.wordwave.grammarbook;

import com.wordwave.grammar.Grammar;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Getter
@Entity
@DynamicInsert
public class GrammarBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ColumnDefault(value = "일반")
    private String name;

    @OneToMany(mappedBy = "grammarBook", cascade = CascadeType.ALL)
    private List<Grammar> grammars;
}
