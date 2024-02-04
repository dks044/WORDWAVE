package com.wordwave.vocabook;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VocaBookRepository extends JpaRepository<VocaBook, Long> {
	ArrayList<VocaBook> findAll();
}
