package com.wordwave.user;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    
    @Test
    @Transactional
    @Rollback(false)
    void findUserNameByEmailTest() { //테스트 성공
    	String errorEmail = "error@error.com";
    	assertThrows(RuntimeException.class, () -> userService.getUserNameByEmail(errorEmail));
        String notErrorEmail = "un08217@naver.com";
        assertDoesNotThrow(() -> userService.getUserNameByEmail(notErrorEmail), "에러가 없어야함.");
    }
    
    
}
