package com.wordwave.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;
    
    // 메일보내기
    public void sendEmail(String email,String subject,String text) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject(subject);
            Context context = new Context();
            context.setVariable("mainSubject", subject);
            context.setVariable("text", text);
            String html = templateEngine.process("mail", context);
            helper.setText(html, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            log.error("Failed to send email", e);
            System.out.println("메일 오류");
            throw new IllegalStateException("Failed to send email", e);
        }
    }

    // 랜덤 비밀번호 생성
    public String createRandomPW() {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        char[] password = new char[8];
        
        for (int i = 0; i < 8; i++) {
            password[i] = passwordSet.charAt(rnd.nextInt(passwordSet.length()));
        }
        return new String(password);
    }
}
