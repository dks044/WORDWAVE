package com.wordwave.myvocabook.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MyVocaBookCategoriesDTO {
	private Long id;
	private Set<String> categories = new HashSet<>();
}
