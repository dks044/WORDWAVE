package com.wordwave.grammarbook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrammarBookRepository extends JpaRepository<GrammarBook, Long> {
    Optional<GrammarBook> findByName(String name);
}
