package com.wordwave.myvocabook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wordwave.user.SiteUser;

public interface MyVocaBookRepository extends JpaRepository<MyVocaBook, Long>{
	List<MyVocaBook> findAllByUser(SiteUser user);
	
	@Query("select mv.category "
			+"from MyVoca mv "
			+ "where mv.myVocaBook.id = :myVocaBookId")
    List<String> findCategoriesByMyVocaBookId(@Param("myVocaBookId") long myVocaBookId);
}
