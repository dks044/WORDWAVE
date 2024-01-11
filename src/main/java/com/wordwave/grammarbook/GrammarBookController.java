package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/grammar")
    public ResponseEntity<Object> saveGrammar(@RequestBody GrammarDto grammarDto) {
        this.grammarBookService.saveGrammar(grammarDto);
        return ResponseEntity.ok(null);
    }
}
