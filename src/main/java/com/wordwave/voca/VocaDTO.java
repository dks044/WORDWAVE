package com.wordwave.voca;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VocaDTO {
	private String korWord;
    private String engWord;
    private String category;
    private Long vocaBookId;
}
