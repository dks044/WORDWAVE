package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GrammarBookService {
    private final GrammarBookRepository grammarBookRepository;
    public GrammarBookDto getGrammarBookById(Long id) {
        Optional<GrammarBook> grammarBook = this.grammarBookRepository.findById(id);
        if (grammarBook.isEmpty()) {
            throw new DataNotFoundException("Grammar book not found.");
        }
        GrammarBookDto grammarBookDto = new GrammarBookDto();
        grammarBookDto.setName(grammarBook.get().getName());
        grammarBookDto.setGrammars(grammarBook.get().getGrammars().stream()
                .map(grammar -> new GrammarDto(grammar.getSentence(), grammar.getGrammarBook().getName()))
                .toList());
        return grammarBookDto;
    }

    @Transactional
    public void createGrammarBook(GrammarBookDto grammarBookDto) {
        //TODO: grammarBookDto를 grammarBook으로 변환해서 저장하기
    }
}
