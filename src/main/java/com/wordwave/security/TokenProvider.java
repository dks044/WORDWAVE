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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenProvider {
	private static final String ISSUER = "WORDWAVE";
	private static final byte[] JWT_SECRET_KEY = Key.JWT_SECREAT_KEY.getValueBytes();
	
	
	public String create(SiteUser user, HttpServletResponse response) {
		//기한 설정 (현재 1일)
		Date expiryDate = Date.from(Instant.now()
											.plus(1,ChronoUnit.DAYS));
		SecretKey secretKey = Keys.hmacShaKeyFor(JWT_SECRET_KEY);
		
		String token = Jwts.builder()
					.setSubject(String.valueOf(user.getId()))
					.setIssuer(ISSUER)
					.setIssuedAt(new Date())
					.setExpiration(expiryDate)
					.signWith(secretKey,SignatureAlgorithm.HS512)
					.compact();
	    // 쿠키 생성 및 설정
	    Cookie cookie = new Cookie("token", token);
	    cookie.setHttpOnly(true); //httpOnly로 설정
	    cookie.setMaxAge(24 * 60 * 60); // 쿠키 유효 시간 설정 (24시간)
	    response.addCookie(cookie);
		
		return token;
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
