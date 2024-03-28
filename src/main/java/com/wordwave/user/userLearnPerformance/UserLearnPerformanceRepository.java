package com.wordwave.user.userLearnPerformance;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wordwave.user.SiteUser;

public interface UserLearnPerformanceRepository extends JpaRepository<UserLearnPerformance, Long>{
	UserLearnPerformance findByUserAndCategory(SiteUser user, String category);
	
    @Query("SELECT ulp FROM UserLearnPerformance ulp WHERE ulp.user.id = :userId ORDER BY ulp.lastAttempted DESC")
    List<UserLearnPerformance> findLastAttemptedByUserId(@Param("userId") Long userId, Pageable pageable);
    
    @Query("SELECT ulp FROM UserLearnPerformance ulp WHERE ulp.user.id = :userId")
    Page<UserLearnPerformance> findAllByUserId(@Param("userId") Long userId, Pageable pageable);
}
