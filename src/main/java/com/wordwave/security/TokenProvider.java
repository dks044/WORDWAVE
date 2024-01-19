package com.wordwave.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.wordwave.user.SiteUser;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenProvider {
	private static final String SECREAT_KEY = "HJrtrgFJGggFfgergwergwefwerwerwefsdfWEUKFHEY7regergdfgergrrgEUKFGWEKFG";
	private static final String ISSUER = "WORDWAVE";
	
	public String create(SiteUser user) {
		//기한 설정 (현재 1일)
		Date expiryDate = Date.from(Instant.now()
											.plus(1,ChronoUnit.DAYS)
				);
		
		return Jwts.builder()
					.signWith(SignatureAlgorithm.HS512, SECREAT_KEY)
					.setSubject(String.valueOf(user.getId()))
					.setIssuer(ISSUER)
					.setIssuedAt(new Date())
					.setExpiration(expiryDate)
					.compact();
					
	}
	
	
}
