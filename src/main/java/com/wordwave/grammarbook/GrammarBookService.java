package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.Grammar;
import com.wordwave.grammarbook.dto.GrammarBookResponseDto;
import com.wordwave.grammarbook.dto.GrammarIdsOfGrammarBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrammarBookService {
    private final GrammarBookRepository grammarBookRepository;

    public GrammarIdsOfGrammarBookDto getGrammarIdsOfGrammarBook(String grammarBookName) {
        GrammarBook grammarBook = this.grammarBookRepository.findByName(grammarBookName)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found"));

        return GrammarIdsOfGrammarBookDto.builder()
                .id(grammarBook.getId())
                .name(grammarBookName)
                .grammarIds(collectAndShuffleGrammarIds(grammarBook.getGrammars()))
                .build();
    }

    private List<Long> collectAndShuffleGrammarIds(List<Grammar> grammars) {
        List<Long> grammarIds = new ArrayList<>();
        for (Grammar grammar : grammars) {
            grammarIds.add(grammar.getId());
        }
        Collections.shuffle(grammarIds);
        return grammarIds;
    }

    public List<GrammarBookResponseDto> getAllGrammarBooksWithoutGrammars() {
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
