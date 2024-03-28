package com.wordwave.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wordwave.user.UserRepository;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//TODO: 유효시간 검사 로직 추가해야함.
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private TokenProvider tokenProvider;
	private final UserRepository userRepository;
	
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = parseBearerToken(request);
			log.info("filter is running...");
			//토큰 검사
			if(token != null && !token.equalsIgnoreCase("null")) {
				String userId = tokenProvider.validateAndGetUserId(token);
				log.info("Authorization user ID :"+userId); // 인증완료 (SecurityContextHolder에 등록)
				AbstractAuthenticationToken authentication = 
						new UsernamePasswordAuthenticationToken(userId, null,AuthorityUtils.NO_AUTHORITIES); //해당 오브젝트에 사용자의 인증정보 저장
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext(); //인증된 사용자를 등록
				securityContext.setAuthentication(authentication);
				SecurityContextHolder.setContext(securityContext);
			}
		}  catch (ExpiredJwtException e) {
		    logger.error("Token expired", e);
		    try {
		        // 리프레시 토큰 쿠키에서 가져오기
		        Cookie[] cookies = request.getCookies();
		        String refreshToken = null;
		        if (cookies != null) {
		            for (Cookie cookie : cookies) {
		                if (cookie.getName().equals("refreshToken")) {
		                    refreshToken = cookie.getValue();
		                    break;
		                }
		            }
		        }

		        // 리프레시 토큰 검증
		        if (refreshToken != null && !refreshToken.isEmpty()) {
		            try {
		                String userId = tokenProvider.validateAndGetUserId(refreshToken); // 리프레시 토큰 검증

		                // 새로운 액세스 토큰 생성 및 쿠키에 저장
		                String newToken = tokenProvider.create(userRepository.findById(Long.parseLong(userId)).orElse(null), response);
		                logger.info("New token issued");

		            } catch (Exception re) {
		                logger.error("Invalid refresh token", re);
		                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		                response.getWriter().write("{\"error\": \"Invalid refresh token\"}");
		                return;
		            }
		        } else {
		            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		            response.getWriter().write("{\"error\": \"Refresh token is missing\"}");
		            return;
		        }

		    } catch (Exception re) {
		        logger.error("Could not refresh token", re);
		        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		        response.getWriter().write("{\"error\": \"Could not refresh token\"}");
		        return;
		    }
		} catch (Exception e) {
		    logger.error("Could not set user authentication in security context", e);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String parseBearerToken(HttpServletRequest request) {
	    // 쿠키에서 토큰 가져오기
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("token")) {
	                return cookie.getValue();
	            }
	        }
	    }
	    return null;
	}
	
}
