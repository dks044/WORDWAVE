package com.wordwave.grammarbook;

import com.wordwave.grammar.Grammar;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

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
