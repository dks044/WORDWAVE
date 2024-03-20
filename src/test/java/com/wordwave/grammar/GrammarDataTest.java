package com.wordwave.grammar;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.wordwave.grammarBook.GrammarBook;
import com.wordwave.grammarBook.GrammarBookService;

import jakarta.transaction.Transactional;


@SpringBootTest
public class GrammarDataTest {

	@Autowired
	private GrammarBookService grammarBookService;
	@Autowired
	private GrammarService grammarService;
	
	//TODO: 실제 있는 GrammarBook 데이터의 id로 지정해야함.
	private static final long GRAMMAR_BOOK_TEST_ID = 1;
	
	@Test
	@Transactional
	@DisplayName("grammarBook 챕터1(현재와 현재진행) 퀴즈데이터 10개 할당하기")
	@Rollback(false)
	@Disabled
	void createGrammarDataChapter1() { //테스트 성공
		GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);
		
		List<GrammarDTO> quizzes = List.of(
			GrammarDTO.builder().engSentence("She __ a book now.")
								.originEngSentence("She is reading a book now.")
								.korSentence("그녀는 지금 책을 읽고 있다.")
								.answer("is reading")
								.blackOptions(List.of("read", "reads", "is reading", "are reading"))
								.category("현재와 현재진행")
								.grammarBook(grammarBook)
								.build(),
			GrammarDTO.builder().engSentence("They __ dinner at 7 PM every day.")
								.originEngSentence("They eat dinner at 7 PM every day.")
								.korSentence("그들은 매일 오후 7시에 저녁을 먹는다.")
								.answer("eat")
								.blackOptions(List.of("eat", "eats", "is eating", "are eating"))
								.category("현재와 현재진행")
								.grammarBook(grammarBook)
								.build(),
								GrammarDTO.builder().engSentence("I __ to the radio every morning.")
			                    .originEngSentence("I listen to the radio every morning.")
			                    .korSentence("나는 매일 아침 라디오를 듣는다.")
			                    .answer("listen")
			                    .blackOptions(List.of("listen", "listens", "is listening", "are listening"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build(),
			GrammarDTO.builder().engSentence("The sun __ in the east.")
			                    .originEngSentence("The sun rises in the east.")
			                    .korSentence("태양은 동쪽에서 뜬다.")
			                    .answer("rises")
			                    .blackOptions(List.of("rise", "rises", "is rising", "are rising"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build(),
			GrammarDTO.builder().engSentence("My brother __ a shower right now.")
			                    .originEngSentence("My brother is taking a shower right now.")
			                    .korSentence("내 동생은 지금 샤워를 하고 있다.")
			                    .answer("is taking")
			                    .blackOptions(List.of("take", "takes", "is taking", "are taking"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build(),
			GrammarDTO.builder().engSentence("We __ for the exam next week.")
			                    .originEngSentence("We are studying for the exam next week.")
			                    .korSentence("우리는 다음 주 시험을 위해 공부하고 있다.")
			                    .answer("are studying")
			                    .blackOptions(List.of("study", "studies", "is studying", "are studying"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build(),
			GrammarDTO.builder().engSentence("He __ his teeth twice a day.")
			                    .originEngSentence("He brushes his teeth twice a day.")
			                    .korSentence("그는 하루에 두 번 이를 닦는다.")
			                    .answer("brushes")
			                    .blackOptions(List.of("brush", "brushes", "is brushing", "are brushing"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build(),
			GrammarDTO.builder().engSentence("It __ outside.")
			                    .originEngSentence("It is raining outside.")
			                    .korSentence("밖에 비가 오고 있다.")
			                    .answer("is raining")
			                    .blackOptions(List.of("rain", "rains", "is raining", "are raining"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build(),
			GrammarDTO.builder().engSentence("Cats __ milk.")
			                    .originEngSentence("Cats like milk.")
			                    .korSentence("고양이는 우유를 좋아한다.")
			                    .answer("like")
			                    .blackOptions(List.of("like", "likes", "is liking", "are liking"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build(),
			GrammarDTO.builder().engSentence("You __ too fast.")
			                    .originEngSentence("You are speaking too fast.")
			                    .korSentence("너는 너무 빨리 말하고 있다.")
			                    .answer("are speaking")
			                    .blackOptions(List.of("speak", "speaks", "is speaking", "are speaking"))
			                    .category("현재와 현재진행")
			                    .grammarBook(grammarBook)
			                    .build()

		);
		
		quizzes.forEach(grammarService::create);
	}
	
    @Test
    @Transactional
    @DisplayName("grammarBook 챕터2(과거와 과거진행) 퀴즈데이터 10개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter2() { //테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("I __ a movie last night.")
                                .originEngSentence("I watched a movie last night.")
                                .korSentence("나는 어젯밤에 영화를 봤다.")
                                .answer("watched")
                                .blackOptions(List.of("watch", "watches", "watched", "was watching"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They __ dinner when I arrived.")
                                .originEngSentence("They were eating dinner when I arrived.")
                                .korSentence("나가 도착했을 때 그들은 저녁을 먹고 있었다.")
                                .answer("were eating")
                                .blackOptions(List.of("eat", "eats", "were eating", "are eating"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She __ to music yesterday.")
                                .originEngSentence("She listened to music yesterday.")
                                .korSentence("그녀는 어제 음악을 들었다.")
                                .answer("listened")
                                .blackOptions(List.of("listen", "listens", "listened", "was listening"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
                                GrammarDTO.builder().engSentence("We __ in London for three years.")
                                .originEngSentence("We lived in London for three years.")
                                .korSentence("우리는 3년 동안 런던에 살았다.")
                                .answer("lived")
                                .blackOptions(List.of("live", "lives", "lived", "were living"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He __ a book when the lights went out.")
                                .originEngSentence("He was reading a book when the lights went out.")
                                .korSentence("불이 꺼졌을 때 그는 책을 읽고 있었다.")
                                .answer("was reading")
                                .blackOptions(List.of("read", "reads", "was reading", "were reading"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They __ to the radio when I entered the room.")
                                .originEngSentence("They were listening to the radio when I entered the room.")
                                .korSentence("나가 방에 들어갔을 때 그들은 라디오를 듣고 있었다.")
                                .answer("were listening")
                                .blackOptions(List.of("listen", "listens", "was listening", "were listening"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I __ tired last night.")
                                .originEngSentence("I was tired last night.")
                                .korSentence("나는 어젯밤에 피곤했다.")
                                .answer("was")
                                .blackOptions(List.of("am", "is", "was", "were"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She __ a cake when you called her.")
                                .originEngSentence("She was baking a cake when you called her.")
                                .korSentence("당신이 그녀에게 전화했을 때 그녀는 케이크를 굽고 있었다.")
                                .answer("was baking")
                                .blackOptions(List.of("bakes", "baked", "was baking", "were baking"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("It __ when we left the house.")
                                .originEngSentence("It was raining when we left the house.")
                                .korSentence("우리가 집을 떠났을 때 비가 오고 있었다.")
                                .answer("was raining")
                                .blackOptions(List.of("rains", "rained", "was raining", "were raining"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("You __ very fast when the accident happened.")
                                .originEngSentence("You were driving very fast when the accident happened.")
                                .korSentence("사고가 발생했을 때 당신은 매우 빠르게 운전하고 있었다.")
                                .answer("were driving")
                                .blackOptions(List.of("drive", "drives", "was driving", "were driving"))
                                .category("과거와 과거진행")
                                .grammarBook(grammarBook)
                                .build()
        );

        quizzes.forEach(grammarService::create);
    }


}
