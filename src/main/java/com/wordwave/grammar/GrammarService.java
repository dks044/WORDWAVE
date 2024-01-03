package com.wordwave.grammar;

import com.wordwave.grammarbook.GrammarBook;
import com.wordwave.grammarbook.GrammarBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrammarService {
    private final GrammarRepository grammarRepository;
    private final GrammarBookRepository grammarBookRepository;

    public void createGrammar(GrammarDto grammarDto) {
        GrammarBook grammarBook = grammarBookRepository.findByName(grammarDto.getGrammarBookName())
                .orElseGet(GrammarBook.builder().name(grammarDto.getGrammarBookName())::build);
        grammarRepository.save(Grammar.builder()
                .sentence(grammarDto.getSentence())
                .grammarBook(grammarBook)
                .build());
    }
}
