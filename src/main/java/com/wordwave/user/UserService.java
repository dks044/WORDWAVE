package com.wordwave.user;

import org.springframework.stereotype.Service;

import com.wordwave.security.Key;

import io.jsonwebtoken.Jwts;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private static final byte[] JWT_SECRET_KEY = Key.JWT_SECREAT_KEY.getValueBytes();
	
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
		if(userRepository.existsByUserName(userName)) {
			log.warn("UserName is already exists {}",userName);
			throw new RuntimeException("UserName is already exists");
		}
		
		return userRepository.save(user);
	}
	
	public SiteUser getByCredentials(final String userName, final String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
	
	public String getUserNameFromJwt(String token) {
		String userName = Jwts.parserBuilder()
							  .setSigningKey(JWT_SECRET_KEY)
							  .build()
							  .parseClaimsJws(token)
							  .getBody()
							  .getSubject();
		return userName;
	}
	
}
