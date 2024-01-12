package com.wordwave.grammarbook;

import com.wordwave.grammar.GrammarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<GrammarBook>> getAllGrammarBooks() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.grammarBookService.getAllGrammarBooks());
    }

    @PostMapping("/grammar")
    public ResponseEntity<Object> saveGrammar(@RequestBody GrammarDto grammarDto) {
        this.grammarBookService.saveGrammar(grammarDto);
        return ResponseEntity.status(HttpStatus.OK).body("Saved");
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
