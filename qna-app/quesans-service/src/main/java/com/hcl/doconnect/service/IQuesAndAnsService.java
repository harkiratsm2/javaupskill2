package com.hcl.doconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.doconnect.entity.Answer;
import com.hcl.doconnect.entity.Question;
import com.hcl.doconnect.to.AnswerTO;
import com.hcl.doconnect.to.QuesAndAnsTO;
import com.hcl.doconnect.to.QuestionTO;

@Service
public interface IQuesAndAnsService {

	String addQuestion(QuestionTO question);

	String addAnswer(AnswerTO answer);

	List<QuesAndAnsTO> findAllQuesAndAns();

	String approveQuestion(int quesId);

	String approveAnswer(int ansId);

	List<QuesAndAnsTO> findApprovedQuesAndAns();

	List<QuesAndAnsTO> searchQuesAndAns(String quesName);

	String rejectQuestion(int quesId);

	String rejectAnswer(int ansId);

	List<Question> getQuestionsByUsername(String username);

	List<Answer> getAnswersByUsername(String username);

	List<Question> getQuestionsByStatus();

	List<Answer> getAnswersByStatus();

}
