package com.wordwave.voca;

import static org.mockito.ArgumentMatchers.anyList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.wordwave.voca.data.VocaDataCode;
import com.wordwave.voca.data.VocaDataTool;
import com.wordwave.vocabook.VocaBook;
import com.wordwave.vocabook.VocaBookRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class VocaTest {
	private static final long VOCABOOK_TOEIC_ID = 1; //토익
	private static final long VOCABOOK_BASIC_ID = 2; //기초
	
	@Autowired
	private VocaBookRepository vocaBookRepository;
	@Autowired
	private VocaService vocaService;
	@Autowired
	private VocaDataCode vocaDataCode;
	@Autowired
	private VocaDataTool vocaDataTool;
	@Autowired
	private VocaRepository vocaRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void createVocaBookTOEIC() { //테스트 성공
		 VocaBook vb = new VocaBook("TOEIC");
		 vocaBookRepository.save(vb);
	}
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void createVocaBookBasic() { //테스트 성공
		 VocaBook vb = new VocaBook("BASIC");
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
	

	
	
	@Test
	@Rollback(false)
	@DisplayName("기초 영단어 500개 넣기")
	@Disabled
	void insertBasicVoca() {
		String[] basicArr = vocaDataCode.basicVoca().split("\n");
		vocaDataTool.insertVocaByString(basicArr, VOCABOOK_BASIC_ID,"기초");
	}
	
	
	@Test
	@DisplayName("vocaBookId,Category로 vocaList얻어내기")
	@Disabled
	void getVocaListVocaByVocaBookIdAndCategory() {
		List<Voca> vocaList = vocaRepository.findByVocaBookIdAndCategory(1L, "법률");
		Collections.shuffle(vocaList);
		for(Voca v : vocaList) {
			System.out.println(v.getCategory());
			System.out.println(v.getId());
			System.out.println(v.getEngWord());
		}
		
	}

	
}
