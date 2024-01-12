package com.wordwave.grammar;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grammar")
public class GrammarController {
    private final GrammarService grammarService;

    @GetMapping("/{id}")
    public ResponseEntity<GrammarDto> getGrammar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.grammarService.getGrammar(id));
    }
}


