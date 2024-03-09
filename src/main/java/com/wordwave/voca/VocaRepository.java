package com.wordwave.voca;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VocaRepository extends JpaRepository<Voca, Long>{
	List<Voca> findByVocaBookIdAndCategory(Long vocaBookId, String category);
}
