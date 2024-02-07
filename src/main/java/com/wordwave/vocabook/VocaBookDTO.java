package com.wordwave.vocabook;

import java.util.List;

import com.wordwave.voca.Voca;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VocaBookDTO {
	private Long id;
    private String name;
    private List<Voca> vocas;
    private String imageURL;
}
