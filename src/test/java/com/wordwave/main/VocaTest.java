package com.wordwave.main;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.wordwave.voca.VocaDTO;
import com.wordwave.voca.VocaService;
import com.wordwave.vocabook.VocaBook;
import com.wordwave.vocabook.VocaBookDTO;
import com.wordwave.vocabook.VocaBookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootTest
public class VocaTest {
	private final VocaService vocaService;
	private final VocaBookRepository bookRepository;
	
	@Test
	void createVocaBook() {
		 VocaBook vb = new VocaBook("TOEIC");
		 bookRepository.save(vb);
	}
	
	
	
	@Disabled
	@Test
	void createVocaTest() {
		VocaDTO v = new VocaDTO();
		v.setKorWord("사과");
		v.setEngWord("apple");
		v.setCategory("과일");
		v.setImgURL("https://cdn.pixabay.com/photo/2017/09/10/15/07/black-apple-2735876_1280.png");
		vocaService.create(null, null);
	}
	
}
