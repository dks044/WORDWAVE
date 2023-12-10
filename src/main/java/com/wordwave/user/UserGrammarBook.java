package com.wordwave.user;

import com.wordwave.grammarbook.GrammarBook;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class UserGrammarBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SiteUser user;

    @ManyToOne
    @JoinColumn(name = "grammarbook_id", referencedColumnName = "id")
    private GrammarBook grammarBook;

    private boolean isCleared;
}
