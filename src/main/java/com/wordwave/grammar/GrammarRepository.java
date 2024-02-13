package com.wordwave.grammar;

import com.wordwave.grammarbook.dto.GrammarNumOfGrammarBookDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, Long> {

    @EntityGraph(attributePaths = {"examples", "grammarBook"})
    Optional<Grammar> findGrammarWithGrammarBookAndExampleById(Long id);

    @Query("select g.grammarBook.id from Grammar g where g.id = :id")
    Long findGrammarBookIdByGrammarId(@Param("id") Long id);

    @EntityGraph(attributePaths = {"examples", "grammarBook"})
    List<Grammar> findGrammarWithGrammarBookAndExampleByIdIn(Set<Long> ids);

    @Query("select new com.wordwave.grammarbook.dto.GrammarNumOfGrammarBookDto(g.grammarBook.id, g.grammarBook.name, count(*)) from Grammar g group by g.grammarBook.id")
    List<GrammarNumOfGrammarBookDto> findNumOfAllGrammarBooks();
}
