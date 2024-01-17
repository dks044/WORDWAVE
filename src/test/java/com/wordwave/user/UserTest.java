package com.wordwave.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UserTest {
	@Autowired
    UserRepository userRepository;
	@Autowired
    UserService userService;
    
    @Test
    @Transactional
    @Rollback(false)
    @Disabled
    void createSiteUserTest() {//테스트성공
        UserDTO ud = UserDTO.builder()
                .userName("테스트계정")
                .password("1234")
                .email("buzz7811@naver.com")
                .phoneNumber("010-1234-5678")
                .createUserDate(LocalDateTime.now())
                .point(0)
                .build();
        SiteUser user = userService.convertDtoToEntity(ud);
        userService.create(user);

        SiteUser foundUser = userRepository.findByUserName("테스트계정");
        assertNotNull(foundUser);
        assertEquals("테스트계정", foundUser.getUserName());
    }
}
