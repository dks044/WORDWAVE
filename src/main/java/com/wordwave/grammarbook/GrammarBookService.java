package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.GrammarDto;
import com.wordwave.grammar.GrammarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrammarBookService {
    private final GrammarBookRepository grammarBookRepository;
    private final GrammarRepository grammarRepository;

    public GrammarBookDto getGrammarBookById(Long id) {
        GrammarBook grammarBook = this.grammarBookRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found."));

        GrammarBookDto grammarBookDto = new GrammarBookDto();
        grammarBookDto.setName(grammarBook.getName());
        grammarBookDto.setGrammarDtos(grammarBook.getGrammars().stream()
                .map(grammar -> new GrammarDto(grammar.getSentence(), grammarBook.getName()))
                .toList());
        return grammarBookDto;
    }
}
