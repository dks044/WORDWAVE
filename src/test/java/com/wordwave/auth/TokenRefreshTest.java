package com.wordwave.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.wordwave.security.JwtAuthenticationFilter;
import com.wordwave.security.TokenProvider;
import com.wordwave.user.SiteUser;
import com.wordwave.user.UserRepository;


import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootTest
public class TokenRefreshTest {

    @InjectMocks
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Mock
    @Autowired
    private TokenProvider tokenProvider;

    @Mock
    @Autowired
    private UserRepository userRepository; // 실제 userRepository의 인터페이스 이름으로 대체해야 합니다.

    @Mock
    private FilterChain filterChain;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.request = new MockHttpServletRequest();
        this.response = new MockHttpServletResponse();
    }

    @Test
    @DisplayName("토큰 만료 로직이 잘 작동하는지 검증한다.")
    @Disabled
    void whenAccessTokenExpired_thenRefreshToken() throws Exception {
        // 가정: 액세스 토큰이 만료되었고, 리프레시 토큰은 유효함
        when(request.getCookies()).thenReturn(new Cookie[] { new Cookie("refreshToken", "validRefreshToken") });
        when(tokenProvider.validateAndGetUserId(anyString())).thenThrow(ExpiredJwtException.class).thenReturn("user123");
        
        // 새로운 토큰 생성 로직 모의
        when(tokenProvider.create(any(), any(HttpServletResponse.class))).thenReturn("newAccessToken");
        
        // 사용자 정보 로딩 로직 모의
        SiteUser mockUser = mock(SiteUser.class); 
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(mockUser));

        // 메소드 실행
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // 검증: 새로운 액세스 토큰이 발급되었는지 확인
        verify(tokenProvider, times(1)).create(any(), any(HttpServletResponse.class));
        
        // filterChain.doFilter가 호출되었는지 확인
        verify(filterChain, times(1)).doFilter(request, response);
    }

   

}