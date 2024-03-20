package com.wordwave.grammarBook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GrammarBookRepository extends JpaRepository<GrammarBook, Long> {
	@Query("select g.category from Grammar g where g.grammarBook.id = :grammarBookId")
    List<String> findCategoriesByGrammarBookId(@Param("grammarBookId") long grammarBookId);
}
