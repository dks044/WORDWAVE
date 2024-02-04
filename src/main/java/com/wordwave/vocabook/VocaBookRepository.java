package com.wordwave.vocabook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VocaBookRepository extends JpaRepository<VocaBook, Long> {
	List<VocaBook> findAll();
}
