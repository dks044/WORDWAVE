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
	
	//TODO: 실제 있는 GrammarBook 데이터로
	private static final long GRAMMAR_BOOK_TEST_ID = 1; //기초회화
	
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

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터3(현재완료) 퀴즈데이터 10개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter3() { //테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);
        
        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("I __ my homework.")
                                .originEngSentence("I have finished my homework.")
                                .korSentence("나는 숙제를 끝냈다.")
                                .answer("have finished")
                                .blackOptions(List.of("have finished", "has finished", "is finishing", "are finishing"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She __ to New York.")
                                .originEngSentence("She has gone to New York.")
                                .korSentence("그녀는 뉴욕에 갔다.")
                                .answer("has gone")
                                .blackOptions(List.of("have gone", "has gone", "is going", "are going"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They __ the movie yet.")
                                .originEngSentence("They have not seen the movie yet.")
                                .korSentence("그들은 아직 영화를 보지 않았다.")
                                .answer("have not seen")
                                .blackOptions(List.of("have not seen", "has not seen", "is not seeing", "are not seeing"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("We __ for her birthday party.")
                                .originEngSentence("We have already shopped for her birthday party.")
                                .korSentence("우리는 이미 그녀의 생일 파티를 위해 쇼핑을 했다.")
                                .answer("have already shopped")
                                .blackOptions(List.of("have shopped", "has shopped", "is shopping", "are shopping"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He __ his car.")
                                .originEngSentence("He has sold his car.")
                                .korSentence("그는 자동차를 팔았다.")
                                .answer("has sold")
                                .blackOptions(List.of("have sold", "has sold", "is selling", "are selling"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("It __ a lot today.")
                                .originEngSentence("It has rained a lot today.")
                                .korSentence("오늘은 많이 비가 왔다.")
                                .answer("has rained")
                                .blackOptions(List.of("have rained", "has rained", "is raining", "are raining"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("My friends __ to the concert.")
                                .originEngSentence("My friends have gone to the concert.")
                                .korSentence("내 친구들은 콘서트에 갔다.")
                                .answer("have gone")
                                .blackOptions(List.of("have gone", "has gone", "is going", "are going"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("You __ too much coffee.")
                                .originEngSentence("You have drunk too much coffee.")
                                .korSentence("너는 너무 많은 커피를 마셨다.")
                                .answer("have drunk")
                                .blackOptions(List.of("have drunk", "has drunk", "is drinking", "are drinking"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She __ the book three times.")
                                .originEngSentence("She has read the book three times.")
                                .korSentence("그녀는 그 책을 세 번 읽었다.")
                                .answer("has read")
                                .blackOptions(List.of("have read", "has read", "is reading", "are reading"))
                                .category("현재완료")
                                .grammarBook(grammarBook)
                                .build()
        );

        quizzes.forEach(grammarService::create);
    }

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터4(미래) 퀴즈데이터 10개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter4() { //테스트 성공

        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("I __ go to the gym tomorrow.")
                                .originEngSentence("I will go to the gym tomorrow.")
                                .korSentence("나는 내일 체육관에 갈 것이다.")
                                .answer("will")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She __ visit her grandmother next week.")
                                .originEngSentence("She is going to visit her grandmother next week.")
                                .korSentence("그녀는 다음 주에 할머니를 방문할 것이다.")
                                .answer("is going to")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They __ start a new project soon.")
                                .originEngSentence("They are going to start a new project soon.")
                                .korSentence("그들은 곧 새 프로젝트를 시작할 것이다.")
                                .answer("are going to")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("We __ have dinner at 8 PM.")
                                .originEngSentence("We will have dinner at 8 PM.")
                                .korSentence("우리는 오후 8시에 저녁을 먹을 것이다.")
                                .answer("will")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He __ finish his work by tomorrow.")
                                .originEngSentence("He will finish his work by tomorrow.")
                                .korSentence("그는 내일까지 그의 일을 마칠 것이다.")
                                .answer("will")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("It __ rain tomorrow.")
                                .originEngSentence("It is going to rain tomorrow.")
                                .korSentence("내일은 비가 올 것이다.")
                                .answer("is going to")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("My friends __ come over tonight.")
                                .originEngSentence("My friends are going to come over tonight.")
                                .korSentence("내 친구들은 오늘 밤에 올 것이다.")
                                .answer("are going to")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
                                GrammarDTO.builder().engSentence("You __ feel better soon.")
                                .originEngSentence("You will feel better soon.")
                                .korSentence("너는 곧 더 좋아질 것이다.")
                                .answer("will")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I __ start my new job next month.")
                                .originEngSentence("I am going to start my new job next month.")
                                .korSentence("나는 다음 달에 새로운 일을 시작할 것이다.")
                                .answer("am going to")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The movie __ begin at 9 o'clock.")
                                .originEngSentence("The movie will begin at 9 o'clock.")
                                .korSentence("영화는 9시에 시작할 것이다.")
                                .answer("will")
                                .blackOptions(List.of("will", "is going to", "am going to", "are going to"))
                                .category("미래")
                                .grammarBook(grammarBook)
                                .build()
                                );
        quizzes.forEach(grammarService::create);
    }
    
    @Test
    @Transactional
    @DisplayName("grammarBook 챕터5(조동사) 퀴즈데이터 10개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter5() { // 테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("You __ drive without a license.")
                                .originEngSentence("You can't drive without a license.")
                                .korSentence("너는 면허 없이 운전할 수 없다.")
                                .answer("can't")
                                .blackOptions(List.of("can't", "mustn't", "needn't", "may not"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She __ swim very well.")
                                .originEngSentence("She can swim very well.")
                                .korSentence("그녀는 매우 잘 수영할 수 있다.")
                                .answer("can")
                                .blackOptions(List.of("can", "could", "might", "should"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They __ see us tomorrow.")
                                .originEngSentence("They might see us tomorrow.")
                                .korSentence("그들은 내일 우리를 볼지도 모른다.")
                                .answer("might")
                                .blackOptions(List.of("might", "can", "will", "would"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He __ help you now.")
                                .originEngSentence("He must help you now.")
                                .korSentence("그는 지금 당신을 도와야만 한다.")
                                .answer("must")
                                .blackOptions(List.of("must", "should", "can", "might"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I __ go to the doctor.")
                                .originEngSentence("I should go to the doctor.")
                                .korSentence("나는 의사에게 가야 한다.")
                                .answer("should")
                                .blackOptions(List.of("should", "must", "could", "would"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("You __ have told me earlier.")
                                .originEngSentence("You could have told me earlier.")
                                .korSentence("너는 더 일찍 나에게 말했어야 했다.")
                                .answer("could have")
                                .blackOptions(List.of("could have", "should have", "must have", "might have"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They __ be arriving any minute.")
                                .originEngSentence("They might be arriving any minute.")
                                .korSentence("그들은 언제든지 도착할지도 모른다.")
                                .answer("might be")
                                .blackOptions(List.of("might be", "could be", "will be", "should be"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("We __ leave before it gets dark.")
                                .originEngSentence("We must leave before it gets dark.")
                                .korSentence("우리는 어두워지기 전에 떠나야 한다.")
                                .answer("must")
                                .blackOptions(List.of("must", "should", "have to", "ought to"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("You __ not worry too much.")
                                .originEngSentence("You shouldn't worry too much.")
                                .korSentence("너는 너무 걱정하지 않아도 된다.")
                                .answer("shouldn't")
                                .blackOptions(List.of("shouldn't", "mustn't", "couldn't",
                                		"don't have to"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build(),
                                GrammarDTO.builder().engSentence("It __ rain later today.")
                                .originEngSentence("It may rain later today.")
                                .korSentence("오늘 나중에 비가 올지도 모른다.")
                                .answer("may")
                                .blackOptions(List.of("may", "might", "will", "should"))
                                .category("조동사")
                                .grammarBook(grammarBook)
                                .build()
                                );
        quizzes.forEach(grammarService::create);
    }
    
    @Test
    @Transactional
    @DisplayName("grammarBook 챕터6(수동태) 퀴즈데이터 7개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter6() { // 테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("The book __ by the author last year.")
                                .originEngSentence("The book was written by the author last year.")
                                .korSentence("그 책은 작년에 저자에 의해 쓰여졌다.")
                                .answer("was written")
                                .blackOptions(List.of("was written", "is written", "has been written", "was writing"))
                                .category("수동태")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("A new song __ every month.")
                                .originEngSentence("A new song is released every month.")
                                .korSentence("매달 새로운 노래가 출시된다.")
                                .answer("is released")
                                .blackOptions(List.of("is released", "was released", "is being released", "has been released"))
                                .category("수동태")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The windows __ cleaned every weekend.")
                                .originEngSentence("The windows are cleaned every weekend.")
                                .korSentence("창문들은 매 주말마다 청소된다.")
                                .answer("are cleaned")
                                .blackOptions(List.of("are cleaned", "were cleaned", "have been cleaned", "are being cleaned"))
                                .category("수동태")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("This song __ known all over the world.")
                                .originEngSentence("This song is known all over the world.")
                                .korSentence("이 노래는 전 세계에서 알려져 있다.")
                                .answer("is known")
                                .blackOptions(List.of("is known", "was known", "has been known", "is being known"))
                                .category("수동태")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The project __ completed by next month.")
                                .originEngSentence("The project will be completed by next month.")
                                .korSentence("그 프로젝트는 다음 달까지 완료될 것이다.")
                                .answer("will be completed")
                                .blackOptions(List.of("will be completed", "has been completed", "is completed", "was completed"))
                                .category("수동태")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The message __ already sent.")
                                .originEngSentence("The message has already been sent.")
                                .korSentence("메시지는 이미 보내졌다.")
                                .answer("has already been sent")
                                .blackOptions(List.of("has already been sent", "was already sent", "is already sent", "had already been sent"))
                                .category("수동태")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The cake __ made by my mother.")
                                .originEngSentence("The cake was made by my mother.")
                                .korSentence("그 케이크는 내 어머니가 만들었다.")
                                .answer("was made")
                                .blackOptions(List.of("was made", "is made", "has been made", "was being made"))
                                .category("수동태")
                                .grammarBook(grammarBook)
                                .build()
        );
        quizzes.forEach(grammarService::create);
    }

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터7(의문문) 퀴즈데이터 8개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter7() { // 테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("How long __ you been living here?")
                                .originEngSentence("How long have you been living here?")
                                .korSentence("얼마나 오래 이곳에 살고 있니?")
                                .answer("have")
                                .blackOptions(List.of("have", "has", "had", "do"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Where __ they going to travel next year?")
                                .originEngSentence("Where are they going to travel next year?")
                                .korSentence("그들은 내년에 어디로 여행갈 예정인가?")
                                .answer("are")
                                .blackOptions(List.of("are", "is", "do", "were"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("What __ you do last weekend?")
                                .originEngSentence("What did you do last weekend?")
                                .korSentence("지난 주말에 무엇을 했니?")
                                .answer("did")
                                .blackOptions(List.of("did", "do", "does", "had"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Who __ the door?")
                                .originEngSentence("Who opened the door?")
                                .korSentence("누가 문을 열었나?")
                                .answer("opened")
                                .blackOptions(List.of("opened", "opens", "open", "had opened"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("When __ we meet again?")
                                .originEngSentence("When will we meet again?")
                                .korSentence("우리는 언제 다시 만날까?")
                                .answer("will")
                                .blackOptions(List.of("will", "would", "can", "do"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Why __ she crying?")
                                .originEngSentence("Why is she crying?")
                                .korSentence("왜 그녀는 우는 거야?")
                                .answer("is")
                                .blackOptions(List.of("is", "was", "does", "are"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Which book __ you like the best?")
                                .originEngSentence("Which book do you like the best?")
                                .korSentence("너는 어떤 책을 가장 좋아해?")
                                .answer("do")
                                .blackOptions(List.of("do", "does", "did", "are"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Can __ help me with this problem?")
                                .originEngSentence("Can you help me with this problem?")
                                .korSentence("이 문제를 도와줄 수 있어?")
                                .answer("you")
                                .blackOptions(List.of("you", "she", "they", "it"))
                                .category("의문문")
                                .grammarBook(grammarBook)
                                .build()
        );
        quizzes.forEach(grammarService::create);
    }

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터8(-ing와 to + 동사원형) 퀴즈데이터 8개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter8() { // 테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("I enjoy __ (read) science fiction books.")
                                .originEngSentence("I enjoy reading science fiction books.")
                                .korSentence("저는 과학 소설 책을 읽는 것을 즐깁니다.")
                                .answer("reading")
                                .blackOptions(List.of("reading", "to read", "read", "reads"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She decided __ (go) to the gym.")
                                .originEngSentence("She decided to go to the gym.")
                                .korSentence("그녀는 체육관에 가기로 결정했습니다.")
                                .answer("to go")
                                .blackOptions(List.of("to go", "going", "go", "goes"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They avoid __ (eat) junk food.")
                                .originEngSentence("They avoid eating junk food.")
                                .korSentence("그들은 정크 푸드를 먹는 것을 피합니다.")
                                .answer("eating")
                                .blackOptions(List.of("eating", "to eat", "eat", "ate"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("We plan __ (visit) Paris next year.")
                                .originEngSentence("We plan to visit Paris next year.")
                                .korSentence("우리는 내년에 파리를 방문할 계획입니다.")
                                .answer("to visit")
                                .blackOptions(List.of("to visit", "visiting", "visit", "visits"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He can't stand __ (be) in crowded places.")
                                .originEngSentence("He can't stand being in crowded places.")
                                .korSentence("그는 붐비는 곳에 있는 것을 견딜 수 없습니다.")
                                .answer("being")
                                .blackOptions(List.of("being", "to be", "be", "is"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She suggested __ (have) dinner at a new restaurant.")
                                .originEngSentence("She suggested having dinner at a new restaurant.")
                                .korSentence("그녀는 새로운 식당에서 저녁을 먹는 것을 제안했습니다.")
                                .answer("having")
                                .blackOptions(List.of("having", "to have", "have", "has"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I look forward to __ (meet) you.")
                                .originEngSentence("I look forward to meeting you.")
                                .korSentence("당신을 만나는 것을 기대합니다.")
                                .answer("meeting")
                                .blackOptions(List.of("meeting", "to meet", "meet", "meets"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build(),
                                GrammarDTO.builder().engSentence("It helps __ (learn) English with friends.")
                                .originEngSentence("It helps to learn English with friends.")
                                .korSentence("친구들과 함께 영어를 배우는 것이 도움이 됩니다.")
                                .answer("to learn")
                                .blackOptions(List.of("to learn", "learning", "learn", "learns"))
                                .category("-ing와 to + 동사원형")
                                .grammarBook(grammarBook)
                                .build()
        );

        quizzes.forEach(grammarService::create);
    }

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터9(명사와 대명사 퀴즈) 데이터 8개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter9() { // 테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("Everyone should bring __ own lunch.")
                                .originEngSentence("Everyone should bring their own lunch.")
                                .korSentence("누구나 자신의 점심을 가져와야 한다.")
                                .answer("their")
                                .blackOptions(List.of("their", "his", "her", "its"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("One of the students has forgotten __ book.")
                                .originEngSentence("One of the students has forgotten his book.")
                                .korSentence("학생 중 한 명이 그의 책을 잊어버렸다.")
                                .answer("his")
                                .blackOptions(List.of("his", "their", "her", "its"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The company has its __ headquarters in New York.")
                                .originEngSentence("The company has its own headquarters in New York.")
                                .korSentence("그 회사는 뉴욕에 자체 본사를 가지고 있다.")
                                .answer("own")
                                .blackOptions(List.of("own", "its", "their", "our"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Each of the players has to wear __ uniform.")
                                .originEngSentence("Each of the players has to wear his uniform.")
                                .korSentence("각 선수는 자신의 유니폼을 입어야 한다.")
                                .answer("his")
                                .blackOptions(List.of("his", "their", "her", "its"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Neither of the arguments was __ point.")
                                .originEngSentence("Neither of the arguments was to the point.")
                                .korSentence("두 주장 중 어느 것도 핵심을 찌르지 못했다.")
                                .answer("to the")
                                .blackOptions(List.of("to the", "in the", "on the", "at the"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Both of the girls have __ rooms cleaned.")
                                .originEngSentence("Both of the girls have their rooms cleaned.")
                                .korSentence("그 두 소녀는 모두 자신의 방을 청소했다.")
                                .answer("their")
                                .blackOptions(List.of("their", "her", "his", "its"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Someone has left __ umbrella.")
                                .originEngSentence("Someone has left his or her umbrella.")
                                .korSentence("누군가 그의 또는 그녀의 우산을 두고 갔다.")
                                .answer("his or her")
                                .blackOptions(List.of("his or her", "their", "his", "her"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Many a student has failed __ exam.")
                                .originEngSentence("Many a student has failed the exam.")
                                .korSentence("많은 학생들이 그 시험에서 낙제했다.")
                                .answer("the")
                                .blackOptions(List.of("the", "a", "an", "their"))
                                .category("명사와 대명사")
                                .grammarBook(grammarBook)
                                .build()
                                );
        quizzes.forEach(grammarService::create);
    }

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터10(수량 표현) 퀴즈 데이터 8개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter10() { //테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("I have __ apples in my bag.")
                                .originEngSentence("I have two apples in my bag.")
                                .korSentence("제 가방에는 사과가 두 개 있습니다.")
                                .answer("two")
                                .blackOptions(List.of("two", "three", "four", "five"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("There are __ books on the table.")
                                .originEngSentence("There are several books on the table.")
                                .korSentence("테이블 위에는 책이 여러 권 있습니다.")
                                .answer("several")
                                .blackOptions(List.of("several", "few", "many", "much"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She drank __ water than usual.")
                                .originEngSentence("She drank less water than usual.")
                                .korSentence("그녀는 평소보다 물을 덜 마셨습니다.")
                                .answer("less")
                                .blackOptions(List.of("less", "fewer", "more", "many"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("There were __ people at the concert.")
                                .originEngSentence("There were a lot of people at the concert.")
                                .korSentence("콘서트에는 많은 사람들이 있었습니다.")
                                .answer("a lot of")
                                .blackOptions(List.of("a lot of", "few", "several", "a couple of"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He ate __ pieces of cake.")
                                .originEngSentence("He ate three pieces of cake.")
                                .korSentence("그는 케이크를 세 조각 먹었습니다.")
                                .answer("three")
                                .blackOptions(List.of("three", "four", "five", "six"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I need __ sugar for this recipe.")
                                .originEngSentence("I need a little sugar for this recipe.")
                                .korSentence("이 레시피에는 약간의 설탕이 필요합니다.")
                                .answer("a little")
                                .blackOptions(List.of("a little", "a few", "much", "many"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They bought __ bottles of wine.")
                                .originEngSentence("They bought a couple of bottles of wine.")
                                .korSentence("그들은 와인 몇 병을 샀습니다.")
                                .answer("a couple of")
                                .blackOptions(List.of("a couple of", "several", "a few", "many"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("We saw __ stars in the sky last night.")
                                .originEngSentence("We saw countless stars in the sky last night.")
                                .korSentence("어젯밤 우리는 하늘에 수많은 별들을 보았습니다.")
                                .answer("countless")
                                .blackOptions(List.of("countless", "few", "several", "many"))
                                .category("수량 표현")
                                .grammarBook(grammarBook)
                                .build()
        );
        quizzes.forEach(grammarService::create);
    }

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터11(형용사와 부사) 퀴즈 데이터 10개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter11() {// 테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("She sings __.")
                                .originEngSentence("She sings beautifully.")
                                .korSentence("그녀는 아름답게 노래한다.")
                                .answer("beautifully")
                                .blackOptions(List.of("beautifully", "beautiful", "beauty", "beautify"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He runs __.")
                                .originEngSentence("He runs fast.")
                                .korSentence("그는 빠르게 달린다.")
                                .answer("fast")
                                .blackOptions(List.of("fast", "faster", "fastest", "slow"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("This flower smells __.")
                                .originEngSentence("This flower smells sweet.")
                                .korSentence("이 꽃은 달콤하게 냄새가 난다.")
                                .answer("sweet")
                                .blackOptions(List.of("sweet", "sweetly", "sour", "sourly"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She looked at me __.")
                                .originEngSentence("She looked at me sadly.")
                                .korSentence("그녀는 슬프게 나를 바라보았다.")
                                .answer("sadly")
                                .blackOptions(List.of("sadly", "sad", "sadden", "sadness"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
           GrammarDTO.builder().engSentence("The movie ended __.")
                                .originEngSentence("The movie ended abruptly.")
                                .korSentence("영화는 갑자기 끝났다.")
                                .answer("abruptly")
                                .blackOptions(List.of("abruptly", "abrupt", "abruptness", "slowly"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They laughed __.")
                                .originEngSentence("They laughed loudly.")
                                .korSentence("그들은 크게 웃었다.")
                                .answer("loudly")
                                .blackOptions(List.of("loudly", "loud", "louder", "softly"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The sun shines __.")
                                .originEngSentence("The sun shines brightly.")
                                .korSentence("태양은 밝게 빛난다.")
                                .answer("brightly")
                                .blackOptions(List.of("brightly", "bright", "brighter", "dimly"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He speaks __.")
                                .originEngSentence("He speaks clearly.")
                                .korSentence("그는 명확하게 말한다.")
                                .answer("clearly")
                                .blackOptions(List.of("clearly", "clear", "clearest", "vaguely"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She writes __.")
                                .originEngSentence("She writes neatly.")
                                .korSentence("그녀는 깔끔하게 글을 쓴다.")
                                .answer("neatly")
                                .blackOptions(List.of("neatly", "neat", "neater", "messily"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The flowers grow __.")
                                .originEngSentence("The flowers grow wildly.")
                                .korSentence("꽃들은 거칠게 자란다.")
                                .answer("wildly")
                                .blackOptions(List.of("wildly", "wild", "wilder", "tame"))
                                .category("형용사와 부사")
                                .grammarBook(grammarBook)
                                .build()
        );

        quizzes.forEach(grammarService::create);

    }
    
    @Test
    @Transactional
    @DisplayName("grammarBook 챕터12(전치사와 구동사) 퀴즈 데이터 10개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter12() {// 테스트 성공
    	GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);
        
        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("She is looking __ her missing cat.")
                                .originEngSentence("She is looking for her missing cat.")
                                .korSentence("그녀는 그녀의 실종된 고양이를 찾고 있다.")
                                .answer("for")
                                .blackOptions(List.of("for", "to", "on", "at"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They gave __ smoking last year.")
                                .originEngSentence("They gave up smoking last year.")
                                .korSentence("그들은 작년에 담배를 끊었다.")
                                .answer("up")
                                .blackOptions(List.of("up", "in", "on", "off"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
                                GrammarDTO.builder().engSentence("She is looking __ her keys.")
                                .originEngSentence("She is looking for her keys.")
                                .korSentence("그녀는 그녀의 열쇠를 찾고 있다.")
                                .answer("for")
                                .blackOptions(List.of("for", "up", "after", "on"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("They gave __ smoking.")
                                .originEngSentence("They gave up smoking.")
                                .korSentence("그들은 흡연을 그만두었다.")
                                .answer("up")
                                .blackOptions(List.of("up", "in", "off", "on"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Please, fill out this form __.")
                                .originEngSentence("Please, fill out this form completely.")
                                .korSentence("이 양식을 완전히 작성해 주세요.")
                                .answer("completely")
                                .blackOptions(List.of("completely", "complete", "completing", "completion"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The teacher went __ the instructions again.")
                                .originEngSentence("The teacher went over the instructions again.")
                                .korSentence("선생님은 지시사항을 다시 설명했다.")
                                .answer("over")
                                .blackOptions(List.of("over", "through", "on", "against"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("The cat jumped __ the wall.")
                                .originEngSentence("The cat jumped over the wall.")
                                .korSentence("고양이가 벽을 넘어 뛰었다.")
                                .answer("over")
                                .blackOptions(List.of("over", "under", "into", "onto"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I ran __ John at the supermarket.")
                                .originEngSentence("I ran into John at the supermarket.")
                                .korSentence("나는 슈퍼마켓에서 존을 우연히 만났다.")
                                .answer("into")
                                .blackOptions(List.of("into", "over", "from", "by"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He is always picking __ me.")
                                .originEngSentence("He is always picking on me.")
                                .korSentence("그는 항상 나를 괴롭힌다.")
                                .answer("on")
                                .blackOptions(List.of("on", "up", "in", "over"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("Let's get __ with the meeting.")
                                .originEngSentence("Let's get on with the meeting.")
                                .korSentence("회의를 계속 진행합시다.")
                                .answer("on")
                                .blackOptions(List.of("on", "over", "in", "to"))
                                .category("전치사와 구동사")
                                .grammarBook(grammarBook)
                                .build()
        );
        quizzes.forEach(grammarService::create);
    }
    

    @Test
    @Transactional
    @DisplayName("grammarBook 챕터13(접속사와 절) 퀴즈 데이터 10개 할당하기")
    @Rollback(false)
    @Disabled
    void createGrammarDataChapter13() {//테스트 성공
        GrammarBook grammarBook = grammarBookService.getById(GRAMMAR_BOOK_TEST_ID);

        List<GrammarDTO> quizzes = List.of(
            GrammarDTO.builder().engSentence("I will call you __ I arrive at the station.")
                                .originEngSentence("I will call you when I arrive at the station.")
                                .korSentence("나는 역에 도착하면 너에게 전화할 거야.")
                                .answer("when")
                                .blackOptions(List.of("when", "if", "because", "although"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("She is sad __ her cat died.")
                                .originEngSentence("She is sad because her cat died.")
                                .korSentence("그녀는 그녀의 고양이가 죽어서 슬프다.")
                                .answer("because")
                                .blackOptions(List.of("because", "if", "although", "when"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("We can't go out __ it is raining.")
                                .originEngSentence("We can't go out because it is raining.")
                                .korSentence("비가 오기 때문에 우리는 밖에 나갈 수 없다.")
                                .answer("because")
                                .blackOptions(List.of("because", "if", "although", "when"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("__ he is smart, he doesn't do well in school.")
                                .originEngSentence("Although he is smart, he doesn't do well in school.")
                                .korSentence("그가 똑똑함에도 불구하고, 학교에서 잘하지 못한다.")
                                .answer("Although")
                                .blackOptions(List.of("Although", "Because", "If", "When"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("You should take an umbrella __ it might rain later.")
                                .originEngSentence("You should take an umbrella in case it might rain later.")
                                .korSentence("나중에 비가 올 수도 있으니 우산을 챙겨야 해.")
                                .answer("in case")
                                .blackOptions(List.of("in case", "if", "although", "when"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("__ you need help, please let me know.")
                                .originEngSentence("If you need help, please let me know.")
                                .korSentence("도움이 필요하면, 제게 알려주세요.")
                                .answer("If")
                                .blackOptions(List.of("If", "Although", "Because", "When"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("He went to bed early __ he was tired.")
                                .originEngSentence("He went to bed early because he was tired.")
                                .korSentence("그는 피곤해서 일찍 잠자리에 들었다.")
                                .answer("because")
                                .blackOptions(List.of("because", "if", "although", "when"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I didn't go to the party __ I was sick.")
                                .originEngSentence("I didn't go to the party because I was sick.")
                                .korSentence("나는 아파서 파티에 가지 않았다.")
                                .answer("because")
                                .blackOptions(List.of("because", "if", "although", "when"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("__ it was cold, we decided to stay home.")
                                .originEngSentence("Because it was cold, we decided to stay home.")
                                .korSentence("추워서 우리는 집에 머물기로 결정했다.")
                                .answer("Because")
                                .blackOptions(List.of("Because", "If", "Although", "When"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build(),
            GrammarDTO.builder().engSentence("I study English __ I can communicate with my foreign friends.")
                                .originEngSentence("I study English so that I can communicate with my foreign friends.")
                                .korSentence("나는 외국인 친구들과 소통할 수 있도록 영어를 공부한다.")
                                .answer("so that")
                                .blackOptions(List.of("so that", "if", "although", "when"))
                                .category("접속사와 절")
                                .grammarBook(grammarBook)
                                .build()
        );
        quizzes.forEach(grammarService::create);
    }
}
