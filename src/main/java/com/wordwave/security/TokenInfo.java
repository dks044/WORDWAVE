package com.wordwave.security;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class TokenInfo {
    private String grantType;
    private String accessToken;
}
