package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.Grammar;
import com.wordwave.grammar.GrammarExampleToGrammarExampleDtoConverter;
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
                        .grammarExamples(GrammarExampleToGrammarExampleDtoConverter.convert(grammar.getExamples()))
                        .build());
            }
        }

        return GrammarBookResponseDto.builder()
                .id(id)
                .name(grammarBook.getName())
                .grammars(grammarDtos)
                .build();
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

    public Long getGrammarBookIdByGrammarBookName(String grammarBookName) {
        return this.grammarBookRepository.findIdByName(grammarBookName);
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
