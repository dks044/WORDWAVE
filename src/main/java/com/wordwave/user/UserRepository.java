package com.wordwave.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	SiteUser findByUserName(String userName);
	Boolean existsByUserName(String userName);
	SiteUser findByUserNameAndPassword(String userName, String password);
	
}
