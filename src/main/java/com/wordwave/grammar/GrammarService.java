package com.wordwave.grammar;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrammarService {
	private final GrammarRepository grammarRepository;
	
}
