package com.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pojo.Question;


@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);

	
	@Query(nativeQuery = true, value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ")
	List<Integer> findRandomQuestionByCategory(@Param("category") String category, @Param("numQ") int numQ);
	
}
