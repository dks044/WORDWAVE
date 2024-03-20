package com.wordwave.grammarBook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GrammarBookRepository extends JpaRepository<GrammarBook, Long> {
	List<GrammarBook> findAll();
}
