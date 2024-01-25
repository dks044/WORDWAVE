package com.wordwave.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.wordwave.user.SiteUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenProvider {
	private static final String ISSUER = "WORDWAVE";
	private static final byte[] JWT_SECRET_KEY = Key.JWT_SECREAT_KEY.getValueBytes();
	
	
	public String create(SiteUser user) {
		//기한 설정 (현재 1일)
		Date expiryDate = Date.from(Instant.now()
											.plus(1,ChronoUnit.DAYS));
		SecretKey secretKey = Keys.hmacShaKeyFor(JWT_SECRET_KEY);
		
		return Jwts.builder()
					.setSubject(String.valueOf(user.getId()))
					.setIssuer(ISSUER)
					.setIssuedAt(new Date())
					.setExpiration(expiryDate)
					.signWith(secretKey,SignatureAlgorithm.HS512)
					.compact();
					
	}
	
	public String validateAndGetUserId(String token) {
		
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(JWT_SECRET_KEY)
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	
}
