package com.hcl.doconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.doconnect.entity.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findAllByStatus(String status);

	@Query("SELECT q FROM Question q WHERE q.question LIKE %:quesName%")
	List<Question> searchQuestionByName(@Param("quesName") String quesName);

	List<Question> findAllByUsername(String username);
	
	Question findById(int id);

}
