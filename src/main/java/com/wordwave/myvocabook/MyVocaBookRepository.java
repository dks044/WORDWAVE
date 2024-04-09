package com.wordwave.myvocabook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wordwave.user.SiteUser;

public interface MyVocaBookRepository extends JpaRepository<MyVocaBook, Long>{
	List<MyVocaBook> findAllByUser(SiteUser user);
	
	@Query("select mv.category "
		       + "from MyVoca mv "
		       + "join mv.myVocaBook mvb "
		       + "where mvb.id = :myVocaBookId and mvb.user.id = :userId")
		List<String> findCategoriesByMyVocaBookIdAndUserId(@Param("myVocaBookId") long myVocaBookId, @Param("userId") long userId);

}
