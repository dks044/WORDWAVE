package com.wordwave.voca;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

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
	@DisplayName("토익 영단어 챕터1 채용파트 영단어 40개 넣기")
	@Disabled
	void insertToeicVocaChapter1() {
		String recruiting = "resume|	이력서|	채용\r\n"
				+ "applicant|	지원자 신청자|	채용\r\n"
				+ "requirement|	필요조건 요건|	채용\r\n"
				+ "meet|	(필요요구 등을)만족시키다|	채용\r\n"
				+ "qualified|	자격있는 적격의|	채용\r\n"
				+ "candidate|	후보자 지원자|	채용\r\n"
				+ "confidence|	확신 자신 신임|	채용\r\n"
				+ "highly|	매우 대단히|	채용\r\n"
				+ "professional|	전문적인 직업의 전문가|	채용\r\n"
				+ "interview|	면접 면접을 보다|	채용\r\n"
				+ "hire|	고용하다|	채용\r\n"
				+ "training|	교육 훈련|	채용\r\n"
				+ "reference|	추천서 참고|	채용\r\n"
				+ "position|	일자리 직책 두다|	채용\r\n"
				+ "achievement|	성취 달성|	채용\r\n"
				+ "impressed|	인상 깊게 생각하는 감명을 받은|	채용\r\n"
				+ "excellent|	훌륭한|	채용\r\n"
				+ "eligible|	자격이 있는 적격의|	채용\r\n"
				+ "identify|	알아보다 확인하다|	채용\r\n"
				+ "associate|	관련시키다|	채용\r\n"
				+ "condition|	조건|	채용\r\n"
				+ "employment|	고용|	채용\r\n"
				+ "lack|	~이 없다 부족|	채용\r\n"
				+ "managerial|	관리의|	채용\r\n"
				+ "diligent|	성실한|	채용\r\n"
				+ "familiar|	익숙한 친숙한|	채용\r\n"
				+ "proficiency|	숙달 능숙|	채용\r\n"
				+ "prospective|	장래의 미래의|	채용\r\n"
				+ "appeal|	관심을 끌다 매력적이다|	채용\r\n"
				+ "specialize|	~을 전공하다 전문적으로 다루다|	채용\r\n"
				+ "apprehensive|	걱정하는 염려하는|	채용\r\n"
				+ "consultant|	고문 컨설턴트|	채용\r\n"
				+ "entitle|	자격을 주다|	채용\r\n"
				+ "degree|	학위|	채용\r\n"
				+ "payroll|	임금대장 금료명부|	채용\r\n"
				+ "recruit|	(신입사원등을)모집하다|	채용\r\n"
				+ "certification|	증명서 증명|	채용\r\n"
				+ "occupation|	직업|	채용\r\n"
				+ "wage|	임금 급료|	채용\r\n";
		String[] recruitingArr = recruiting.split("\n");
		for(String sentence : recruitingArr) {
			String[] word = sentence.split("\\|");
			VocaDTO voca = VocaDTO.builder()
							      .korWord(word[1].trim())
							      .engWord(word[0].trim())
							      .category(word[2].trim())
							      .build();
			vocaService.create(voca, VOCABOOK_TOEIC_ID);
			
		}
	}
	@Test
	@Rollback(false)
	@DisplayName("토익 영단어 챕터2 법률파트 영단어 40개 넣기")
	@Disabled
	void insertToeicVocaChapter2() {
		String legislation = "attire|	복장 옷차림새|	법률\r\n"
				+ "code|	규범 관례;암호|	법률\r\n"
				+ "concern|	우려 걱정 문제 일 ~을 걱정스럽게 하다; 영향을 미치다 관련되다.|	법률\r\n"
				+ "policy|	규정; 보험 증권|	법률\r\n"
				+ "comply|	준수하다 따르다|	법률\r\n"
				+ "regulation|	규정|	법률\r\n"
				+ "exception|	예외|	법률\r\n"
				+ "adhere|	지키다 고수하다|	법률\r\n"
				+ "severely|	엄격하게 심하게|	법률\r\n"
				+ "refrain|	자제하다 삼가다|	법률\r\n"
				+ "permission|	허락 허가|	법률\r\n"
				+ "access|	이용권한 접근;통로 ~에 접근하다 도달하다|	법률\r\n"
				+ "thoroughly|	철저하게 완전히 대단히|	법률\r\n"
				+ "revise|	(의견 계획을)수정하다 변경하다|	법률\r\n"
				+ "approach|	접근법 처리방법|	법률\r\n"
				+ "approval|	승인 인가|	법률\r\n"
				+ "form|	종류 유형 양식|	법률\r\n"
				+ "immediately|	즉시 곧|	법률\r\n"
				+ "inspection|	점검 검사|	법률\r\n"
				+ "arrangement|	준비 마련 주선|	법률\r\n"
				+ "procedure|	절차|	법률\r\n"
				+ "negative|	부정적인 비관적인|	법률\r\n"
				+ "mandate|	명령하다 지시하다 권한 지시 명령|	법률\r\n"
				+ "effect|	(법률등의)효력 효과 영향 결과로서 ~을 가져오다|	법률\r\n"
				+ "drastically|	심하게 과감하게 철저하게|	법률\r\n"
				+ "according to|	~에 따라|	법률\r\n"
				+ "enable|	(무엇을)가능하게 하다|	법률\r\n"
				+ "standard|	기준 표준|	법률\r\n"
				+ "constant|	지속적인 끊임없이 계속하는|	법률\r\n"
				+ "act|	법령 결의서; 행위 행동 결정하다 판결을 내리다 행동하다|	법률\r\n"
				+ "compensation|	보상금 보상|	법률\r\n"
				+ "ban|	금지 금지하다|	법률\r\n"
				+ "obligation|	의무 책임|	법률\r\n"
				+ "authorize|	~을 인가하다 권한을 부여하다.|	법률\r\n"
				+ "prohibit|	금지하다|	법률\r\n"
				+ "abolish|	(제도 법률등을)폐지하다|	법률\r\n"
				+ "enforce|	(법률을)시행하다 집행하다|	법률\r\n"
				+ "habit|	습관 버릇|	법률\r\n"
				+ "lagislation|	법률 법규|	법률\r\n"
				+ "restrict|	한정하다 제한하다|	법률\r\n";
		String[] legislationArr = legislation.split("\n");
		for(String sentence : legislationArr) {
			String[] word = sentence.split("\\|");
			VocaDTO voca = VocaDTO.builder()
								  .engWord(word[0].trim())
								  .korWord(word[1].trim())
								  .category(word[2].trim())
								  .build();
			vocaService.create(voca, VOCABOOK_TOEIC_ID);
		}
				
		
	}
	@Test
	@Rollback(false)
	@DisplayName("기초 영단어 500개 넣기")
	void insertBasicVoca() {
		String[] basicArr = vocaDataCode.basicVoca().split("\n");
		for(String sentence : basicArr) {
			String[] word = sentence.split("\\|");
			VocaDTO voca = VocaDTO.builder()
								  .engWord(word[0].trim())
								  .korWord(word[1].trim())
								  .category("기초")
								  .build();
			vocaService.create(voca, VOCABOOK_BASIC_ID);
		}
	}
}
