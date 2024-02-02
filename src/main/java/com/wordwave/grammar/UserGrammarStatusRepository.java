package com.wordwave.grammar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGrammarStatusRepository extends JpaRepository<UserGrammarStatus, Long> {
    Optional<List<UserGrammarStatus>> findByUserId(Long userId);
}
