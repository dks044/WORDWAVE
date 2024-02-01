package com.wordwave.emailcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;

@SpringBootTest
public class EmailCodeTest {
	@Autowired
	private  EmailCodeRepository emailCodeRepository;
	@Autowired
	private  EmailCodeService emailCodeService;
	
    @Test
    @Transactional
    @Rollback(false)
	@DisplayName("EmailCode 중복저장시(2번) 어떻게 확인되는지 테스트")
    @Disabled
	void test1() {
		EmailAuthenicateDTO emailAuthenicateDTO = new EmailAuthenicateDTO();
		emailAuthenicateDTO.setEmail("test@test.com");
		emailAuthenicateDTO.setEmailCode("thisissendCode");
		EmailCode emailCode = emailCodeService.converterToEntity(emailAuthenicateDTO);
		emailCodeService.save(emailCode);
		emailCodeService.save(emailCode);
	}
	
}
