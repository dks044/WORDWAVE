package com.wordwave.grammarbook;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/grammar")
@RestController
public class GrammarBookController {
    private final GrammarBookService grammarBookService;


}
