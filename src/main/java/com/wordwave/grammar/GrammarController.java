package com.wordwave.grammar;

import com.wordwave.grammar.dto.ChangeSentenceDto;
import com.wordwave.grammar.dto.GrammarDto;
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
    public ResponseEntity<GrammarDto> getGrammar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.grammarService.getGrammar(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> saveGrammarExample(@RequestBody GrammarDto grammarDto) {
        //grammarDto의 sentence와 grammarBookName은 필요없음
        this.grammarService.saveGrammarExamples(grammarDto);
        return ResponseEntity.status(HttpStatus.OK).body("Saved examples");
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


