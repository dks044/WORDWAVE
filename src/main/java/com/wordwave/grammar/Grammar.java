package com.wordwave.grammar;

import com.wordwave.grammarbook.GrammarBook;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Grammar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String rule;

    @Column
    private String example;

    @ManyToOne(optional = false)
    private GrammarBook grammarBook;
}
