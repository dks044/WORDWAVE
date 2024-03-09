package com.wordwave.vocabook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VocaBookRepository extends JpaRepository<VocaBook, Long> {
	List<VocaBook> findAll();
	
	@Query("select v.category from Voca v where v.vocaBook.id = :vocaBookId")
    List<String> findCategoriesByVocaBookId(@Param("vocaBookId") long vocaBookId);
	
	
}
	