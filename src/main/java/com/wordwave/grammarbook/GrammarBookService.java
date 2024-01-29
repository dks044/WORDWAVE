package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.Grammar;
import com.wordwave.grammar.GrammarExample;
import com.wordwave.grammar.GrammarRepository;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
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

    public GrammarBookResponseDto getGrammarBook(Long id) {
        GrammarBook grammarBook = this.grammarBookRepository.findGrammarBookById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found"));

        List<GrammarDto> grammarDtos = new ArrayList<>();
        List<Grammar> grammars = grammarBook.getGrammars();
        for (Grammar grammar : grammars) {
            if (grammar != null) {
                grammarDtos.add(GrammarDto.builder()
                        .id(grammar.getId())
                        .sentence(grammar.getSentence())
                        .grammarBookName(grammarBook.getName())
                        .grammarExamples(convertGrammarExampleDto(grammar.getExamples()))
                        .build());
            }
        }

        return GrammarBookResponseDto.builder()
                .id(id)
                .name(grammarBook.getName())
                .grammars(grammarDtos)
                .build();
    }

    private List<GrammarExampleDto> convertGrammarExampleDto(List<GrammarExample> grammarExamples) {
        List<GrammarExampleDto> grammarExampleDtos = new ArrayList<>();
        for (GrammarExample grammarExample : grammarExamples) {
            if(grammarExample != null) {
                grammarExampleDtos.add(GrammarExampleDto.builder()
                        .example(grammarExample.getExample())
                        .isAnswer(grammarExample.getIsAnswer())
                        .build());
            }
        }
        return grammarExampleDtos;
    }

    public List<GrammarBookResponseDto> getAllGrammarBooksWithoutGrammar() {
        List<GrammarBookResponseDto> grammarBooks = new ArrayList<>();
        for (GrammarBook grammarBook : this.grammarBookRepository.findAll()) {
            GrammarBookResponseDto responseDto = GrammarBookResponseDto.builder()
                    .id(grammarBook.getId())
                    .name(grammarBook.getName())
                    .build();
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
        GrammarBook grammarBook = this.grammarBookRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found"));
        grammarBook.changeName(newName, this.grammarBookRepository.findAll());
    }
}
