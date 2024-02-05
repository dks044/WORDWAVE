package com.wordwave.grammar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, Long> {
    @Query("select g.grammarBook.id from Grammar g where g.id = :id")
    Long findGrammarBookIdByGrammarId(@Param("id") Long id);
}
