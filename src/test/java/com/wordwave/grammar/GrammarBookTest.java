package com.wordwave.grammar;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.wordwave.grammarBook.GrammarBookDTO;
import com.wordwave.grammarBook.GrammarBookService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class GrammarBookTest {
	
	@Autowired
	private GrammarBookService grammarBookService;
	
	
	@Test
	@Transactional
	@Rollback(false)
	@DisplayName("grammarBookTest 생성 및 생성테스트")
	@Disabled 
	void createGrammarBookTest() { //테스트 성공
		GrammarBookDTO grammarBookDTO = GrammarBookDTO.builder().name("기초 회화")
																.imageURL("https://wordwave-bucket.s3.ap-northeast-2.amazonaws.com/grammar/%EA%B8%B0%EC%B4%88+%ED%9A%8C%ED%99%94.png")
																.build();
		grammarBookService.create(grammarBookDTO);
	}
}
