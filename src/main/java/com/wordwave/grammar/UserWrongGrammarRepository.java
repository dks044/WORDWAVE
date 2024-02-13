package com.wordwave.grammar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserWrongGrammarRepository extends JpaRepository<UserWrongGrammar, Long> {

    List<UserWrongGrammar> findByUserId(Long userId);
    List<UserWrongGrammar> findByUserIdAndGrammarBookId(Long userId, Long grammarBookId);
    Optional<UserWrongGrammar> findByUserIdAndWrongGrammarId(Long userId, Long wrongGrammarId);
}
