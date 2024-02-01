package com.wordwave.emailcode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailCodeRepository extends JpaRepository<EmailCode, Long> {
	EmailCode findByEmailAndEmailCode(String email,String emailCode);
	EmailCode findByEmail(String email);
}
