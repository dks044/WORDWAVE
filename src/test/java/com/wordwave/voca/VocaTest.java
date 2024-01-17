package com.wordwave.voca;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.wordwave.voca.VocaDTO;
import com.wordwave.voca.VocaService;
import com.wordwave.vocabook.VocaBook;
import com.wordwave.vocabook.VocaBookDTO;
import com.wordwave.vocabook.VocaBookRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@SpringBootTest
public class VocaTest {
	private static final long VOCABOOK_TOEIC_ID = 1; 
	
	@Autowired
	private VocaBookRepository vocaBookRepository;
	@Autowired
	private VocaService vocaService;
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void createVocaBookTOEIC() { //테스트 성공
		 VocaBook vb = new VocaBook("TOEIC");
		 vocaBookRepository.save(vb);
	}
	
	
	@Test
	@Disabled
	void createVocaTest() { //테스트 성공
		VocaDTO v = new VocaDTO();
		v.setKorWord("사과");
		v.setEngWord("apple");
		v.setCategory("과일");
		v.setImgURL("https://cdn.pixabay.com/photo/2017/09/10/15/07/black-apple-2735876_1280.png");
		vocaService.create(v, VOCABOOK_TOEIC_ID);
	}
	
}
