package com.wordwave.voca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wordwave.vocabook.VocaBook;
import com.wordwave.vocabook.VocaBookService;

@SpringBootTest
public class VocaBookTest {
	@Autowired
	private VocaBookService vocaBookService;
	
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
	void vocaBookCategoryTest() {
		long toeicId = 1;
		Map<Long,List<String>> categories = vocaBookService.getCategoriesOfVocaBook(toeicId);
		for(Map.Entry<Long, List<String>> entry : categories.entrySet()) {
			Long key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println(key +" "+value);
		}
	}
	
	
}
