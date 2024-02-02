package com.wordwave.grammar;

import com.wordwave.grammar.dto.WrongGrammarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user-grammar")
public class UserGrammarStatusController {
    private final UserGrammarStatusService userGrammarStatusService;

    @PostMapping("/")
    public ResponseEntity<?> saveUserWrongGrammars(@RequestBody WrongGrammarDto wrongGrammarDto) {
        this.userGrammarStatusService.saveUserWrongGrammars(wrongGrammarDto);
        return ResponseEntity.status(HttpStatus.OK).body("Saved wrong grammars.");
    }
}
