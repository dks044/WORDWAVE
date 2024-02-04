package com.wordwave.voca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
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
		List<VocaBook> vocaBookList = vocaBookService.getVocaBookList();
		for(VocaBook vb : vocaBookList) {
			assertEquals(vb.getName(), "TOEIC");
		}
	}
	
	@Test
	@Disabled
	void vocaBookCategoryTest() {
		Set<String> categories = vocaBookService.getCategoriesOfVocaBook(1);
		for(String category : categories) {
			System.out.println(category);
		}
	}
	
	
}
