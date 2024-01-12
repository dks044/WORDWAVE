package com.wordwave.grammar;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grammar")
public class GrammarController {
    private final GrammarService grammarService;

    @GetMapping("/{id}")
    public ResponseEntity<GrammarResponseDto> getGrammar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.grammarService.getGrammar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSentence(@PathVariable Long id, @RequestBody GrammarDto grammarDto) {
        this.grammarService.updateSentence(id, grammarDto);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }
}


