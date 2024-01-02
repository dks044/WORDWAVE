package com.wordwave.voca;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VocaDTO {
	private Long id;
	private String korWord;
    private String engWord;
    private String category;
    private Long vocaBookId;
    private String imgURL;
}
