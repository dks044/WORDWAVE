package com.wordwave.myvoca;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyVocaRepository extends JpaRepository<MyVoca, Long>{
	List<MyVoca> findByMyVocaBookIdAndCategory(Long myVocaBookId,String category);
}
