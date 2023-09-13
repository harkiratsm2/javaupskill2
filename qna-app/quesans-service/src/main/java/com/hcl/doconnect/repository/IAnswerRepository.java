package com.hcl.doconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.doconnect.entity.Answer;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Integer> {

	List<Answer> findAllByStatus(String status);

	List<Answer> findAllByUsername(String username);
	
	Answer findById(int id);

}
