package com.wordwave.emailcode;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailCodeService {
	private final EmailCodeRepository emailCodeRepository;
	
	public EmailCode converterToEntity(EmailAuthenicateDTO emailAuthenicateDTO) {
		return EmailCode.builder()
						.email(emailAuthenicateDTO.getEmail())
						.emailCode(emailAuthenicateDTO.getEmailCode())
						.build();
	}
	public void save(EmailCode emailCode) {
		emailCodeRepository.save(emailCode);
	}
}
