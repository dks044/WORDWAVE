package com.wordwave.vocabook;

import java.util.List;
import java.util.Set;

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
    
    //카테고리(voca의 하위필드)
    private Set<String> categories;
}
