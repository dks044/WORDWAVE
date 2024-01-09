package com.wordwave.grammar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrammarRepository extends JpaRepository<Grammar, Long> {
    @Query("select g from Grammar g join fetch g.grammarBook where g.id = :id")
    Optional<Grammar> findById(@Param("id") Long id);
}
