package com.wordwave.myvocabook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wordwave.user.SiteUser;

public interface MyVocaBookRepository extends JpaRepository<MyVocaBook, Long>{
	List<MyVocaBook> findAllByUser(SiteUser user);
	
	
}
