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
	public EmailCode getByCredentials(String email,String emailCode) {
		return emailCodeRepository.findByEmailAndEmailCode(email, emailCode);
	}
	public boolean isEmail(String email) {
		return emailCodeRepository.existsByEmail(email);
	}
	
	public void delete(String email) {
		EmailCode emailCode = emailCodeRepository.findByEmail(email);
		emailCodeRepository.delete(emailCode);
	}
}
