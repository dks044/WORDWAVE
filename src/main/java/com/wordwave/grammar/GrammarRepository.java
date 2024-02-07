package com.wordwave.grammar;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, Long> {

    @EntityGraph(attributePaths = {"examples", "grammarBook"})
    Optional<Grammar> findGrammarWithGrammarBookAndExampleById(Long id);

    @Query("select g.grammarBook.id from Grammar g where g.id = :id")
    Long findGrammarBookIdByGrammarId(@Param("id") Long id);

    List<Grammar> findByGrammarBookId(Long grammarBookId);

    List<Grammar> findByIdIn(List<Long> ids);
}
