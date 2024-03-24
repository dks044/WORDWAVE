package com.wordwave.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	SiteUser findByUserName(String userName);
	Boolean existsByUserName(String userName);
	SiteUser findByUserNameAndPassword(String userName, String password);
	Boolean existsByEmail(String email);
	Boolean existsByPhoneNumber(String phoneNumber);
	SiteUser findByEmail(String email);
	SiteUser findByUserNameAndEmail(String userName,String email);
    @Query("SELECT u.consecutiveLearningDays FROM SiteUser u WHERE u.id = :userId")
    Long findConsecutiveLearningDaysById(@Param("userId") Long userId); //userId로 연속학습일 얻어내기
	
}
