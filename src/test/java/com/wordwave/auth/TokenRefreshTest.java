package com.wordwave.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.wordwave.security.JwtAuthenticationFilter;
import com.wordwave.security.TokenProvider;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserRepository;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class TokenRefreshTest {
	private static final String ISSUER = "WORDWAVE";
	private static final String JWT_SECRET_KEY_STRING = System.getenv("JWT_SECREAT_KEY");
	private static final byte[] JWT_SECRET_KEY = JWT_SECRET_KEY_STRING != null ? JWT_SECRET_KEY_STRING.getBytes() : new byte[0];
	
    @InjectMocks
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Mock
    @Autowired
    private TokenProvider tokenProvider;

    @Mock
    @Autowired
    private UserRepository userRepository; 

    @Mock
    private FilterChain filterChain;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.request = new MockHttpServletRequest();
        this.response = new MockHttpServletResponse();
    }


   //테스트 성공
   @Test
   @DisplayName("액세스 토큰이 만료된다면, 서버에 리프래쉬 토큰을 확인하여 액세스 토큰을 발급하는지 확인한다.")
	void dieForAccessJWT() throws Exception {
		// 임시계정생성
		SiteUser testUser = SiteUser.builder().userName("test").password("1234").build();
		userRepository.save(testUser);
		String refreshToken = tokenProvider.createRefreshToken(testUser);

		// 고의로 0으로 설정
		Date expiryDate = Date.from(Instant.now().plus(0, ChronoUnit.DAYS));
		SecretKey secretKey = Keys.hmacShaKeyFor(JWT_SECRET_KEY);

		// 만료된 액세스 토큰을 쿠키에
		String testExpiredToken = Jwts.builder().setSubject(String.valueOf(testUser.getId())).setIssuer(ISSUER)
				.setIssuedAt(new Date()).setExpiration(expiryDate).signWith(secretKey, SignatureAlgorithm.HS512)
				.compact();

		ResponseCookie responseCookie = ResponseCookie.from("access", testExpiredToken).domain("localhost").path("/")
				.build();

		response.setHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());

		jwtAuthenticationFilter.doFilter(request, response, filterChain);
		// 새로운 액세스 토큰이 쿠키에 추가되었는지 확인
		String cookieValue = response.getHeader("Set-Cookie");
		assertTrue(cookieValue.contains("access"));
	}

}