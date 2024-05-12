package com.wordwave.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
	@Bean(name = "customCorsConfigurationSource")
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // 다른 출처의 자원을 사용할 수 있게 
        // CloudFront 도메인과 로컬 개발 환경 동시 허용

        config.setAllowedOrigins(Arrays.asList("https://wordwave.xyz", "http://localhost:3000","https://www.wordwave.xyz"));

        
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        
        config.setAllowedHeaders(List.of("Authorization","Content-Type", "Accept"));
        //config.setExposedHeaders(List.of("x-auth-token"));
        
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return  source;
    }
}
