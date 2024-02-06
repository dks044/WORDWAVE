package com.wordwave.grammarbook;

import com.wordwave.exception.DataNotFoundException;
import com.wordwave.grammar.*;
import com.wordwave.grammar.dto.GrammarDto;
import com.wordwave.grammar.dto.GrammarExampleDto;
import com.wordwave.grammarbook.dto.GrammarBookResponseDto;
import com.wordwave.grammarbook.dto.GrammarNumOfGrammarBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GrammarBookService {
    private final GrammarBookRepository grammarBookRepository;
    private final GrammarRepository grammarRepository;
    private final GrammarExampleRepository grammarExampleRepository;

    public GrammarBookResponseDto getGrammarBook(String grammarBookName) {
        GrammarBook grammarBook = this.grammarBookRepository.findByName(grammarBookName)
                .orElseThrow(() -> new DataNotFoundException("Grammar book not found"));

        List<Long> grammarIds = grammarBook.getGrammars().stream()
                .map(Grammar::getId)
                .toList();

        List<GrammarExample> grammarExamples = this.grammarExampleRepository.findAllByGrammarIdIn(grammarIds);

        Map<Long, List<GrammarExample>> grammarExamplesMappedGrammarId = grammarExamples.stream()
                .collect(Collectors.groupingBy(example -> example.getGrammar().getId()));

        List<GrammarDto> grammarDtos = new ArrayList<>();
        for (Grammar grammar : grammarBook.getGrammars()) {
            List<GrammarExampleDto> grammarExampleDtos = GrammarExampleToGrammarExampleDtoConverter.convert(grammarExamplesMappedGrammarId.get(grammar.getId()));
            grammarDtos.add(GrammarDto.builder()
                    .id(grammar.getId())
                    .sentence(grammar.getSentence())
                    .grammarBookName(grammarBook.getName())
                    .grammarExamples(grammarExampleDtos)
                    .build());
        }

        return GrammarBookResponseDto.builder()
                .id(grammarBook.getId())
                .name(grammarBookName)
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
