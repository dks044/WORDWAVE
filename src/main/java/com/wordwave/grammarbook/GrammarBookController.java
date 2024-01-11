package com.wordwave.grammarbook;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/grammarbook")
@RestController
public class GrammarBookController {
    private final GrammarBookService grammarBookService;

    @GetMapping("/{id}")
    public ResponseEntity<GrammarBookResponseDto> getGrammarBook(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.grammarBookService.getGrammarBook(id));
    }
}
