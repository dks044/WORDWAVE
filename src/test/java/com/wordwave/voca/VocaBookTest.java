package com.wordwave.voca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.wordwave.vocabook.VocaBook;
import com.wordwave.vocabook.VocaBookDTO;
import com.wordwave.vocabook.VocaBookRepository;
import com.wordwave.vocabook.VocaBookService;

@SpringBootTest
public class VocaBookTest {
	@Autowired
	private VocaBookService vocaBookService;
	@Autowired
	private VocaBookRepository vocaBookRepository;
	
	@Test
	@Disabled
	void vocaBookListViewTest() {
		Map<Long,String> vocaBookList = vocaBookService.getVocaBookNameList();
		for(Map.Entry<Long, String> entry : vocaBookList.entrySet()) {
			Long key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key +" "+value);
		}
	}
	

	
	@Test
	@Disabled
	void vocaBookView() {
		List<VocaBookDTO> vbList = vocaBookService.getVocaBookDTOList();
		for(VocaBookDTO vb : vbList) {
			System.out.println(vb.getId());
			System.out.println(vb.getName());
			System.out.println(vb.getImageURL());
		}
	}
	
	@Test
	@Rollback(false)
	@DisplayName("vocaBook 생성 테스트") //테스트 성공
	@Disabled
	void createVocaBookTest() {
		VocaBookDTO basic = VocaBookDTO.builder()
				 .name("BASIC")
				 .imageURL("https://wordwave-bucket.s3.ap-northeast-2.amazonaws.com/voca/basic.png")
				 .build();
		
		VocaBookDTO toeic = VocaBookDTO.builder()
											 .name("TOEIC")
											 .imageURL("https://wordwave-bucket.s3.ap-northeast-2.amazonaws.com/voca/toeic.png")
											 .build();

		
		
		vocaBookService.create(basic);
		vocaBookService.create(toeic);
	}
	
}
