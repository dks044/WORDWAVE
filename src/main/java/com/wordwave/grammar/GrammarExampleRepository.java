package com.wordwave.grammar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrammarExampleRepository extends JpaRepository<GrammarExample, Long> {
    List<GrammarExample> findAllByGrammarIdIn(List<Long> grammarIds);

}
