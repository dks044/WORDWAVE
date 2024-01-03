package com.wordwave.grammarbook;

import com.wordwave.grammar.Grammar;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class GrammarBookRepositoryTest {
    @Autowired
    GrammarBookRepository grammarBookRepository;

    @Test
    @Rollback(false)
    void cascadePersistTest() {
        GrammarBook grammarBook = GrammarBook.builder().name("test book").build();
        Grammar grammar1 = Grammar.builder().sentence("test sentence1").grammarBook(grammarBook).build();
        Grammar grammar2 = Grammar.builder().sentence("test sentence2").grammarBook(grammarBook).build();
        Grammar grammar3 = Grammar.builder().sentence("test sentence3").grammarBook(grammarBook).build();

        grammarBook.getGrammars().addAll(Lists.newArrayList(grammar1, grammar2, grammar3));

        grammarBookRepository.save(grammarBook);
    }

}