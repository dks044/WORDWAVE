package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.Grammar;
import com.wordwave.grammar.GrammarRepository;
import com.wordwave.grammarbook.dto.GrammarBookResponseDto;
import com.wordwave.grammarbook.dto.GrammarIdsOfGrammarBookDto;
import com.wordwave.grammarbook.dto.GrammarNumOfGrammarBookDto;
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

    public GrammarIdsOfGrammarBookDto getGrammarBook(String grammarBookName) {
        GrammarBook grammarBook = this.grammarBookRepository.findByName(grammarBookName)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found"));

        return GrammarIdsOfGrammarBookDto.builder()
                .id(grammarBook.getId())
                .name(grammarBookName)
                .grammarIds(getGrammarIds(grammarBook.getGrammars()))
                .build();
    }

    private List<Long> getGrammarIds(List<Grammar> grammars) {
        List<Long> grammarIds = new ArrayList<>();
        for (Grammar grammar : grammars) {
            grammarIds.add(grammar.getId());
        }
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

    //N+1 발생
    /**
     * SELECT
     *     gb.id,
     *     gb.name,
     *     COUNT(g.id) AS grammar_count
     * FROM
     *     grammar_book gb
     * LEFT JOIN
     *     grammar g
     * ON
     *     gb.id = g.grammar_book_id
     * GROUP BY
     *     gb.id, gb.name;
     * */
    public List<GrammarNumOfGrammarBookDto> getGrammarNumOfAllGrammarBooks() {
        List<GrammarNumOfGrammarBookDto> responseDtos = new ArrayList<>();
        for (GrammarBook grammarBook : this.grammarBookRepository.findAll()) {
            responseDtos.add(
                    GrammarNumOfGrammarBookDto.builder()
                            .id(grammarBook.getId())
                            .name(grammarBook.getName())
                            .grammarNum(this.grammarRepository.findByGrammarBookId(grammarBook.getId()).size())
                            .build()
            );
        }
        return responseDtos;
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
