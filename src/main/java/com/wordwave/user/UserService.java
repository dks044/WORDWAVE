package com.wordwave.user;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wordwave.security.Key;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private static final byte[] JWT_SECRET_KEY = Key.JWT_SECREAT_KEY.getValueBytes();
	private final PasswordEncoder passwordEncoder;
	
    public SiteUser convertDtoToEntity(UserDTO userDto) {
        return SiteUser.builder()
            .userName(userDto.getUserName())
            .password(userDto.getPassword())
            .email(userDto.getEmail())
            .phoneNumber(userDto.getPhoneNumber())
            .createUserDate(userDto.getCreateUserDate())
            .point(userDto.getPoint())
            .role(UserRole.USER) // Assuming default role as USER
            .build();
    }

	
	public SiteUser create(final SiteUser user) {
		if(user == null || user.getUserName() == null) {
			throw new RuntimeException("Invalid arguments");
		}
		final String userName = user.getUserName();
		final String phoneNumber = user.getPhoneNumber();
		final String email = user.getEmail();
		if(userRepository.existsByUserName(userName)) {
			log.warn("UserName is already exists {}",userName);
			throw new RuntimeException("UserName is already exists");
		}
		if(userRepository.existsByPhoneNumber(phoneNumber)) {
			log.warn("phoneNumber is already exists {}",phoneNumber);
			throw new RuntimeException("phoneNumber is already exists");
		}
		if(userRepository.existsByEmail(email)) {
			log.warn("emalil is already exists {}",email);
			throw new RuntimeException("emalil is already exists");
		}
		
		return userRepository.save(user);
	}
	
	public SiteUser getByCredentials(final String userName, final String password) {
		return userRepository.findByUserNameAndPassword(userName, passwordEncoder.encode(password));
	}
	
	public SiteUser getByUserId(final long id) {
	    Optional<SiteUser> user = userRepository.findById(id);
	    if(!user.isPresent()) {
	        throw new RuntimeException(id+"<= this is not valid");
	    }
	    return user.get();
	}
	
	public boolean validateEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public long getUserIdFromJwt(String token) {
		String tokenInformation = Jwts.parserBuilder()
							  .setSigningKey(JWT_SECRET_KEY)
							  .build()
							  .parseClaimsJws(token)
							  .getBody()
							  .getSubject();
		return Long.parseLong(tokenInformation);
	}
	
	public String getUserNameByEmail(String email) {
		SiteUser user = userRepository.findByEmail(email);
		if(user == null) {
			throw new RuntimeException("not exist by email and userName"+email);
		}
		return user.getUserName();
	}
	
	public SiteUser getSiteUserByUserNameAndEmail(String userName,String email) {
		SiteUser user = userRepository.findByUserNameAndEmail(userName, email);
		if(user == null) {
			throw new RuntimeException("not match : email , userName"+userName+email);
		}
		return user;
	}
	
	public void changeUserPassword(SiteUser user, String newPassword) {
	    user.changePassword(newPassword);
	    userRepository.save(user);
	}
	//쿠키에서 토큰을 가져온다.
	public String getTokenFromRequest(HttpServletRequest request) {
	    Cookie[] cookies = request.getCookies();
	    String token = null;
	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals("token")) {
	            token = cookie.getValue();
	            break;
	        }
	    }
	    if(cookies == null) throw new RuntimeException("cookies is empty");
	    return token;
	}
	
	public void deleteUser(SiteUser user) {
	    userRepository.delete(user);
	}
	
	public SiteUser getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public boolean equalsDatabaseByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	//사용자의 연속학습일 설정 (증감)
	public void increaseUserConsecutiveLearningDays(long userId) {
		SiteUser user = getByUserId(userId);
		long userConsecutiveLearningDays = userRepository.findConsecutiveLearningDaysById(userId);
		user.changeConsecutiveLearningDays(userConsecutiveLearningDays+1);
		userRepository.save(user);
	}
	//사용자의 연속학습일 설정 (초기화)
	public void resetUserConsecutiveLearningDays(long userId) {
		SiteUser user = getByUserId(userId);
		user.changeConsecutiveLearningDays(0);
		userRepository.save(user);
	}
	
}
