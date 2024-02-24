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

    @GetMapping("")
    public ResponseEntity<Object> getGrammar(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "isChoice") boolean isChoice) {
        try {
            if (isChoice) {
                return ResponseEntity.ok().body(this.grammarService.getGrammarWithGrammarBookAndExampleById(id));
            }
            return ResponseEntity.ok().body(this.grammarService.getGrammarSentenceAndKoreanById(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/num-each-grammarbook")
    public ResponseEntity<Object> getGrammarNumOfAllGrammarBooks() {
        try {
            return ResponseEntity.ok().body(this.grammarService.getNumOfAllGrammarBooks());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> saveGrammarAndGrammarExamples(@RequestBody GrammarDto grammarDto) {
        //grammarDto의 sentence와 grammarBookName은 필요없음
        this.grammarService.saveGrammarAndGrammarExamples(grammarDto);
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


