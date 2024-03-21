package com.wordwave.grammar;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface GrammarRepository extends JpaRepository<Grammar, Long>{
	List<Grammar> findByGrammarBookIdAndCategory(Long grammarBookId, String category);
}
