package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.Grammar;
import com.wordwave.grammar.GrammarExample;
import com.wordwave.grammar.GrammarRepository;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammarbook.dto.GrammarBookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrammarBookService {
    private final GrammarBookRepository grammarBookRepository;
    private final GrammarRepository grammarRepository;

    public GrammarBookResponseDto getGrammarBookWithoutGrammarExamples(Long id) {
        GrammarBook grammarBook = getGrammarBookById(id);

        GrammarBookResponseDto grammarBookResponseDto = new GrammarBookResponseDto();
        grammarBookResponseDto.setId(id);
        grammarBookResponseDto.setName(grammarBook.getName());
        grammarBookResponseDto.setGrammars(grammarBook.getGrammars().stream()
                .map(grammar -> new GrammarDto(
                        grammar.getId(),
                        grammar.getSentence(),
                        new ArrayList<>(),
                        grammarBook.getName()
                    )
                )
                .toList());
        return grammarBookResponseDto;
    }

    public List<GrammarBookResponseDto> getAllGrammarBooksWithoutGrammar() {
        List<GrammarBookResponseDto> grammarBooks = new ArrayList<>();
        for (GrammarBook grammarBook : this.grammarBookRepository.findAll()) {
            GrammarBookResponseDto responseDto = new GrammarBookResponseDto(
                    grammarBook.getId(),
                    grammarBook.getName(),
                    new ArrayList<>()
            );
            grammarBooks.add(responseDto);
        }
        return grammarBooks;
    }

    @Transactional
    public void saveGrammarToGrammarBook(GrammarDto grammarDto) {
        // grammarDto의 id는 필요 없음
        GrammarBook grammarBook = this.grammarBookRepository.findByName(grammarDto.getGrammarBookName())
                .orElseGet(() -> createGrammarBook(grammarDto.getGrammarBookName()));

        Grammar grammar = Grammar.builder()
                .sentence(grammarDto.getSentence())
                .grammarBook(grammarBook)
                .build();
        grammar.saveExamples(grammarDto.getGrammarExamples().stream()
                .map(dto -> GrammarExample.builder()
                        .example(dto.getExample())
                        .isAnswer(dto.getIsAnswer())
                        .grammar(grammar)
                        .build()).toList());

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
