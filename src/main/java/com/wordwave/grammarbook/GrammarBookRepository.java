
package com.wordwave.grammarbook;

import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrammarBookRepository extends JpaRepository<GrammarBook, Long> {

    @Override
    @Nonnull
    @Query("select gb from GrammarBook gb join fetch gb.grammars where gb.id = :id")
    Optional<GrammarBook> findById(@Nonnull @Param("id") Long id);

    @Query("select gb from GrammarBook gb join fetch gb.grammars where gb.name = :name")
    Optional<GrammarBook> findByName(@Param("name") String name);

    @Query("select distinct gb from GrammarBook gb left join fetch gb.grammars g left join fetch g.examples ex where gb.id = :id")
    Optional<GrammarBook> findGrammarBookById(@Param("id") Long id);
}
