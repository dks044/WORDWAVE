package com.wordwave.myvoca;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wordwave.myvocabook.MyVocaBook;
import com.wordwave.myvocabook.MyVocaBookRepository;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MyVocaTest {
	private static final long TEST_USER_ID = 1;
	
	@Autowired
	MyVocaBookRepository myVocaBookRepository;
	@Autowired
	UserService userService;
	
	
	@Transactional
	@Test
	@DisplayName("userId를 이용해서 MyVocaBook을 얻을 수 있는지 테스트 한다")
	void findByUserIdTest() {
		SiteUser user = userService.getByUserId(TEST_USER_ID);
		
		MyVocaBook myVocaBook = MyVocaBook.builder().name("테스트중").imageURL("테스트이미지").user(user).build();
		myVocaBookRepository.save(myVocaBook);
		List<MyVocaBook> list = myVocaBookRepository.findAllByUser(user);
		// 결과 검증
		assertThat(list).isNotNull();
		assertThat(list).hasSize(1); // 저장한 데이터가 정확히 1개인지 검증
		assertThat(list.get(0).getName()).isEqualTo("테스트중");
		assertThat(list.get(0).getImageURL()).isEqualTo("테스트이미지");
		assertThat(list.get(0).getUser()).isEqualTo(user);
		
	}
	
}
