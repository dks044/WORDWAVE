package com.wordwave.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	SiteUser findByUserName(String userName);
	Boolean existsByUserName(String userName);
	SiteUser findByUserNameAndPassword(String userName, String password);
	Boolean existsByEmail(String email);
	Boolean existsByPhoneNumber(String phoneNumber);
	SiteUser findByEmail(String email);
	SiteUser findByUserNameAndEmail(String userName,String email);
}
