package com.wordwave.grammarBook;

import java.util.ArrayList;
import java.util.List;

import com.wordwave.grammar.Grammar;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GrammarBookDTO {
	private long id;
	private String name;
	private List<Grammar> grammars = new ArrayList<>();
	private String imageURL;
}
