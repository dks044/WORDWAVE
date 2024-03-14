package com.wordwave.user.userLearnPerformance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wordwave.user.SiteUser;

public interface UserLearnPerformanceRepository extends JpaRepository<UserLearnPerformance, Long>{
	UserLearnPerformance findByUserAndCategory(SiteUser user, String category);
}
