package com.wordwave.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.boot.web.server.Cookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.wordwave.user.SiteUser;
import com.wordwave.user.UserRepository;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenProvider {
	private static final String ISSUER = "WORDWAVE";
    private static final String JWT_SECRET_KEY_STRING = System.getenv("JWT_SECREAT_KEY"); 
    private static final byte[] JWT_SECRET_KEY = JWT_SECRET_KEY_STRING != null ? JWT_SECRET_KEY_STRING.getBytes() : new byte[0];
	private final UserRepository userRepository;
	private final String DOMAIN_LIVE = ".wordwave.xyz"; //배포환경
	private final String DOMAIN_STAGING = "localhost"; //개발환경
	
	//액세스 토큰 생성
	public String create(SiteUser user) {
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
	
		return token;
	}
	//검증된 사용자의 userId을 조회
	public String validateAndGetUserId(String token) {
		
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(JWT_SECRET_KEY)
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	//리프래쉬 토큰 생성
	public String createRefreshToken(final SiteUser user) {
	    Date expiryDate = Date.from(Instant.now().plus(14, ChronoUnit.DAYS)); // 예: 7일 후 만료
	    SecretKey secretKey = Keys.hmacShaKeyFor(JWT_SECRET_KEY);
	    
	    String refreshToken = Jwts.builder()
	    		.setSubject(String.valueOf(user.getId()))
				.setIssuer(ISSUER)
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.claim("token_type", "refresh")
				.signWith(secretKey,SignatureAlgorithm.HS512)
				.compact();

	    user.setRefreshToken(refreshToken);
	    userRepository.save(user);
	    
	    return refreshToken;
	}
	
	//리프래쉬 토큰 검증
	public boolean validateRefreshToken(String token) {
	    try {
	        Claims claims = Jwts.parserBuilder()
	                .setSigningKey(JWT_SECRET_KEY)
	                .build()
	                .parseClaimsJws(token)
	                .getBody();

	        // 리프레시 토큰임을 나타내는 'token_type' 클레임 검증
	        String tokenType = claims.get("token_type", String.class);
	        if (!"refresh".equals(tokenType)) {
	            return false;
	        }

	        // 유효기간 검증
	        Date expiration = claims.getExpiration();
	        return !expiration.before(new Date()); // 현재 날짜와 시간이 만료 날짜와 시간 이전이면 false, 그렇지 않으면 true
	    } catch (JwtException | IllegalArgumentException e) {
	        log.error("Invalid & Expired JWT RefreshToken", e);
	        return false;
	    }
	}
	
	
	//액세스 토큰 발급
	//TODO: 배포환경에서는 주석해제 해야함
	public ResponseCookie generateTokenCookie(String token) {
	    return ResponseCookie.from("access", token)
	    		.domain(DOMAIN_LIVE)
	    		.path("/")
	            .httpOnly(true)
	            .secure(true)
	            .sameSite(Cookie.SameSite.NONE.attributeValue()) 
	            .build();
	}
	
	
	public void responseHeaderToken(String token, HttpServletResponse response) {
	    // Token을 쿠키로 클라이언트에 전송
	    ResponseCookie responseCookie = generateTokenCookie(token);
	    response.setHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
	    //정보 전송할거면 활용
//	    return TokenInfo.builder()
//	    		.grantType("Bearer")
//	    		.accessToken(token)
//	    		.build();
	}
	

	
	
	
	
	
}
