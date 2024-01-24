package com.wordwave.grammar;

import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarResponseDto;
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
    public ResponseEntity<Object> updateSentence(@RequestBody ChangeSentenceDto changeSentenceDto) {
        this.grammarService.updateSentence(changeSentenceDto);
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGrammar(@PathVariable Long id) {
        this.grammarService.deleteGrammar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}


