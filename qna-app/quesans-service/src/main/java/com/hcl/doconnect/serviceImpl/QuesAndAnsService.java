package com.hcl.doconnect.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.doconnect.entity.Answer;
import com.hcl.doconnect.entity.Question;
import com.hcl.doconnect.repository.IAnswerRepository;
import com.hcl.doconnect.repository.IQuestionRepository;
import com.hcl.doconnect.service.IQuesAndAnsService;
import com.hcl.doconnect.to.AnswerTO;
import com.hcl.doconnect.to.QuesAndAnsTO;
import com.hcl.doconnect.to.QuestionTO;

@Service
public class QuesAndAnsService implements IQuesAndAnsService {
	
	@Autowired
	IQuestionRepository iQuestionRepository;
	
	@Autowired
	IAnswerRepository iAnswerRepository;

	public String addQuestion(QuestionTO question) {
		
		Question question1 = new Question(0, question.getQuestion(), question.getTopic(), question.getImageUrl(), question.getUsername(), "pending");

		iQuestionRepository.save(question1);
		
		return "Question Added Successfully";
	}

	public String addAnswer(AnswerTO answer) {

		Answer answer1 = new Answer(0, answer.getAnswer(), answer.getImageUrl(), "pending", answer.getUsername(), answer.getQuesId());
		
		iAnswerRepository.save(answer1);
		
		return "Answer added Successfully";
	}

	public List<QuesAndAnsTO> findAllQuesAndAns() {

		List<Question> questions = iQuestionRepository.findAll();
		
		List<Answer> answers = iAnswerRepository.findAll();
		
		List<QuesAndAnsTO> quesAndAnswers = new ArrayList<QuesAndAnsTO>();
		
		for(Question question : questions)
		{
			QuesAndAnsTO quesAndAnsTO = new QuesAndAnsTO();
			
			quesAndAnsTO.setId(question.getId());
			quesAndAnsTO.setQuestion(question.getQuestion());
			quesAndAnsTO.setTopic(question.getTopic());
			quesAndAnsTO.setImageUrl(question.getImageUrl());
			quesAndAnsTO.setUsername(question.getUsername());
			quesAndAnsTO.setStatus(question.getStatus());
			
			List<Answer> answer1 = new ArrayList<>();
			
			for(Answer answer : answers)
			{
				
				if(question.getId() == answer.getQuesId())
				{
					answer1.add(answer);
				}
			}
			
			quesAndAnsTO.setAnswers(answer1);
			
			quesAndAnswers.add(quesAndAnsTO);
		}
		
		return quesAndAnswers;
	}

	public String approveQuestion(int quesId) {

		Question question = iQuestionRepository.findById(quesId);
		
		if(question != null)
		{
			question.setStatus("approved");
			
			iQuestionRepository.save(question);
			
			return "Question Approved Successfully";
		}
		
		return "Question Not Found";
	}

	public String approveAnswer(int ansId) {

		Answer answer = iAnswerRepository.findById(ansId);
		
		if(answer != null)
		{
			answer.setStatus("approved");
			
			iAnswerRepository.save(answer);
			
			return "Answer Approved Successfully";
		}
		
		return "Answer Not Found";
	}
	
	public String rejectQuestion(int quesId) {

		Question question = iQuestionRepository.findById(quesId);
		
		if(question != null)
		{
			question.setStatus("rejected");
			
			iQuestionRepository.save(question);
			
			return "Question Rejected Successfully";
		}
		
		return "Question Not Found";
	}

	public String rejectAnswer(int ansId) {

		Answer answer = iAnswerRepository.findById(ansId);
		
		if(answer != null)
		{
			answer.setStatus("rejected");
			
			iAnswerRepository.save(answer);
			
			return "Answer Rejected Successfully";
		}
		
		return "Answer Not Found";
	}

	public List<QuesAndAnsTO> findApprovedQuesAndAns() {

		List<Question> questions = iQuestionRepository.findAllByStatus("approved");
		
		List<Answer> answers = iAnswerRepository.findAllByStatus("approved");
		
		List<QuesAndAnsTO> quesAndAnswers = new ArrayList<QuesAndAnsTO>();
		
		for(Question question : questions)
		{
			QuesAndAnsTO quesAndAnsTO = new QuesAndAnsTO();
			
			quesAndAnsTO.setId(question.getId());
			quesAndAnsTO.setQuestion(question.getQuestion());
			quesAndAnsTO.setTopic(question.getTopic());
			quesAndAnsTO.setImageUrl(question.getImageUrl());
			quesAndAnsTO.setUsername(question.getUsername());
			quesAndAnsTO.setStatus(question.getStatus());
			
			List<Answer> answer1 = new ArrayList<>();
			
			for(Answer answer : answers)
			{
				
				if(question.getId() == answer.getQuesId())
				{
					answer1.add(answer);
				}
			}
			
			quesAndAnsTO.setAnswers(answer1);
			
			quesAndAnswers.add(quesAndAnsTO);
		}
		
		return quesAndAnswers;
		
	}

	public List<QuesAndAnsTO> searchQuesAndAns(String quesName) {
		
		List<Question> allQuestions = iQuestionRepository.searchQuestionByName(quesName);
		
		List<Question> questions = new ArrayList<Question>();
		
		for(Question question : allQuestions)
		{
			if(question.getStatus().equals("approved"))
			{
				questions.add(question);
			}
			
		}
		
		List<Answer> answers = iAnswerRepository.findAllByStatus("approved");
		
		List<QuesAndAnsTO> quesAndAnswers = new ArrayList<QuesAndAnsTO>();
		
		for(Question question : questions)
		{
			QuesAndAnsTO quesAndAnsTO = new QuesAndAnsTO();
			
			quesAndAnsTO.setId(question.getId());
			quesAndAnsTO.setQuestion(question.getQuestion());
			quesAndAnsTO.setTopic(question.getTopic());
			quesAndAnsTO.setImageUrl(question.getImageUrl());
			quesAndAnsTO.setUsername(question.getUsername());
			quesAndAnsTO.setStatus(question.getStatus());
			
			List<Answer> answer1 = new ArrayList<>();
			
			for(Answer answer : answers)
			{
				
				if(question.getId() == answer.getQuesId())
				{
					answer1.add(answer);
				}
			}
			
			quesAndAnsTO.setAnswers(answer1);
			
			quesAndAnswers.add(quesAndAnsTO);
		}
		
		return quesAndAnswers;
		
	}

	public List<Question> getQuestionsByUsername(String username) {

		return iQuestionRepository.findAllByUsername(username);
	}

	public List<Answer> getAnswersByUsername(String username) {

		return iAnswerRepository.findAllByUsername(username);
	}

	public List<Question> getQuestionsByStatus() {

		return iQuestionRepository.findAllByStatus("pending");
	}

	public List<Answer> getAnswersByStatus() {

		return iAnswerRepository.findAllByStatus("pending");
	}

}
