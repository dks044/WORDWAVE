package com.wordwave.grammar;

import com.wordwave.grammar.dto.WrongGrammarsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-wrong-grammar")
public class UserGrammarStatusController {
    private final UserGrammarStatusService userGrammarStatusService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public ResponseEntity<?> getUserWrongGrammars(@RequestParam String userName) {
        try {
            return ResponseEntity.ok().body(this.userGrammarStatusService.getUserWrongGrammars(userName));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping()
    public ResponseEntity<?> saveUserWrongGrammars(@RequestBody WrongGrammarsDto wrongGrammarsDto) {
        try {
            this.userGrammarStatusService.saveUserWrongGrammars(wrongGrammarsDto);
            return ResponseEntity.ok().body("Saved wrong grammars.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping()
    public ResponseEntity<?> updateUserLastTryTime(@RequestBody WrongGrammarsDto wrongGrammarsDto) {
        try {
            this.userGrammarStatusService.updateUserLastTryTime(wrongGrammarsDto);
            return ResponseEntity.ok().body("Updated last try time.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping()
    public ResponseEntity<?> deleteUserWrongGrammars(@RequestBody WrongGrammarsDto wrongGrammarsDto) {
        try {
            this.userGrammarStatusService.deleteUserWrongGrammars(wrongGrammarsDto);
            return ResponseEntity.ok().body("Deleted wrong grammars.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
