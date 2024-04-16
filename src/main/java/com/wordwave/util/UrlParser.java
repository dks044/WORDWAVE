package com.wordwave.util;

import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class UrlParser {
    public static String getKeyFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        String path = url.getPath();
        return path.substring(1); // 첫 번째 문자인 '/'를 제거
    }
}
