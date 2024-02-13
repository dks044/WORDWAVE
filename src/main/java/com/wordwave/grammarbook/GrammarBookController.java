package com.wordwave.grammarbook;

import com.wordwave.grammarbook.dto.ChangeGrammarBookNameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/grammarbook")
@RestController
public class GrammarBookController {
    private final GrammarBookService grammarBookService;

    @GetMapping("/{grammarBookName}")
    public ResponseEntity<Object> getGrammarBook(@PathVariable String grammarBookName) {
        try {
            return ResponseEntity
                    .ok()
                    .body(this.grammarBookService.getGrammarBook(grammarBookName));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getGrammarIdsOfAllGrammarBooks() {
        try {
            return ResponseEntity
                    .ok()
                    .body(this.grammarBookService.getAllGrammarBooksWithoutGrammars());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> updateGrammarBookName(@RequestBody ChangeGrammarBookNameDto changeGrammarBookNameDto) {
        this.grammarBookService.updateGrammarBookName(changeGrammarBookNameDto.getId(), changeGrammarBookNameDto.getNewName());
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGrammarBook(@PathVariable Long id) {
        this.grammarBookService.deleteGrammarBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
