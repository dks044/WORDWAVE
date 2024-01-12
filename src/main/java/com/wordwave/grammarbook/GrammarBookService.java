package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.Grammar;
import com.wordwave.grammar.GrammarDto;
import com.wordwave.grammar.GrammarRepository;
import com.wordwave.grammar.GrammarResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrammarBookService {
    private final GrammarBookRepository grammarBookRepository;
    private final GrammarRepository grammarRepository;

    public GrammarBookResponseDto getGrammarBook(Long id) {
        GrammarBook grammarBook = this.grammarBookRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found."));

        GrammarBookResponseDto grammarBookResponseDto = new GrammarBookResponseDto();
        grammarBookResponseDto.setId(id);
        grammarBookResponseDto.setName(grammarBook.getName());
        grammarBookResponseDto.setGrammars(grammarBook.getGrammars().stream()
                .map(grammar -> new GrammarResponseDto(grammar.getId(), grammar.getSentence(), grammarBook.getName()))
                .toList());
        return grammarBookResponseDto;
    }

    public List<GrammarBook> getAllGrammarBooks() {
        return this.grammarBookRepository.findAll();
    }

    @Transactional
    public void saveGrammar(GrammarDto grammarDto) {
        GrammarBook grammarBook = this.grammarBookRepository.findByName(grammarDto.getGrammarBookName())
                .orElseGet(() -> createGrammarBook(grammarDto.getGrammarBookName()));

        Grammar grammar = Grammar.builder()
                .sentence(grammarDto.getSentence())
                .grammarBook(grammarBook)
                .build();

        grammarBook.addGrammar(grammar);
        this.grammarRepository.save(grammar);
    }

    private GrammarBook createGrammarBook(String name) {
        return this.grammarBookRepository.save(GrammarBook.builder().name(name).build());
    }

    public void deleteGrammarBook(Long id) {
        this.grammarBookRepository.deleteById(id);
    }

    @Transactional
    public void updateGrammarBookName(Long id, String newName) {
        GrammarBook grammarBook = getGrammarBookById(id);
        grammarBook.changeName(newName, this.grammarBookRepository.findAll());
    }

    private GrammarBook getGrammarBookById(Long id) {
        return this.grammarBookRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found"));
    }
}
