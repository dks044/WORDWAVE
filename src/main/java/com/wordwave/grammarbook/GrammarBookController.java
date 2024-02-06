package com.wordwave.grammarbook;

import com.wordwave.grammarbook.dto.ChangeGrammarBookNameDto;
import com.wordwave.grammarbook.dto.GrammarBookResponseDto;
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

    @GetMapping("/{grammarBookName}")
    public ResponseEntity<GrammarBookResponseDto> getGrammarBook(@PathVariable String grammarBookName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.grammarBookService.getGrammarBook(grammarBookName));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GrammarBookResponseDto>> getAllGrammarBooks() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.grammarBookService.getAllGrammarBooksWithoutGrammar());
    }

    @GetMapping("/all-grammar-num")
    public ResponseEntity<Object> getGrammarNumOfAllGrammarBooks() {
        try {
            return ResponseEntity.ok().body(this.grammarBookService.getGrammarNumOfAllGrammarBooks());
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
