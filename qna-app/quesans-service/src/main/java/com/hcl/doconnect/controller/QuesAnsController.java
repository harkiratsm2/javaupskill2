package com.hcl.doconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.doconnect.entity.Answer;
import com.hcl.doconnect.entity.Question;
import com.hcl.doconnect.service.IQuesAndAnsService;
import com.hcl.doconnect.to.AnswerTO;
import com.hcl.doconnect.to.QuesAndAnsTO;
import com.hcl.doconnect.to.QuestionTO;

@RestController
@RequestMapping("/quesans")
@CrossOrigin(origins = "http://localhost:3000/")
public class QuesAnsController {
	
	@Autowired
	IQuesAndAnsService iQuesAndAnsService;
	
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestBody QuestionTO question)
	{
		String addStatus = iQuesAndAnsService.addQuestion(question);
		
		return addStatus;
		
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@RequestBody AnswerTO answer)
	{
		String addStatus = iQuesAndAnsService.addAnswer(answer);
		
		return addStatus;
	}
	
	@GetMapping("/getAllQuesAndAns")
	public List<QuesAndAnsTO> getAllQuesAndAns()
	{
		List<QuesAndAnsTO> quesAndAns = iQuesAndAnsService.findAllQuesAndAns();
		
		return quesAndAns;
	}
	
	@GetMapping("/approveQues/{quesId}")
	public String approveQues(@PathVariable int quesId)
	{
		String approveStatus = iQuesAndAnsService.approveQuestion(quesId);
		
		return approveStatus;
	}
	
	@GetMapping("/approveAns/{ansId}")
	public String approveAns(@PathVariable int ansId)
	{
		String approveStatus = iQuesAndAnsService.approveAnswer(ansId);
		
		return approveStatus;
	}
	
	@GetMapping("/rejectQues/{quesId}")
	public String rejectQues(@PathVariable int quesId)
	{
		String approveStatus = iQuesAndAnsService.rejectQuestion(quesId);
		
		return approveStatus;
	}
	
	@GetMapping("/rejectAns/{ansId}")
	public String rejectAns(@PathVariable int ansId)
	{
		String approveStatus = iQuesAndAnsService.rejectAnswer(ansId);
		
		return approveStatus;
	}
	
	@GetMapping("/getApprovedQuesAndAns")
	public List<QuesAndAnsTO> getApprovedQuesAndAns()
	{
		List<QuesAndAnsTO> quesAndAns = iQuesAndAnsService.findApprovedQuesAndAns();
		
		return quesAndAns;
	}
	
	@GetMapping("searchQuestions/{quesName}")
	public List<QuesAndAnsTO> searchQuestions(@PathVariable String quesName)
	{
		List<QuesAndAnsTO> quesAndAns = iQuesAndAnsService.searchQuesAndAns(quesName);
		
		return quesAndAns;
	}
	
	@GetMapping("/getQuesByUsername/{username}")
	public List<Question> getQuesByUsername(@PathVariable String username)
	{
		List<Question> questions = iQuesAndAnsService.getQuestionsByUsername(username);
		
		return questions;
	}
	
	@GetMapping("/getAnsByUsername/{username}")
	public List<Answer> getAnsByUsername(@PathVariable String username)
	{
		List<Answer> answers = iQuesAndAnsService.getAnswersByUsername(username);
		
		return answers;
	}
	
	@GetMapping("/getQuesByStatus")
	public List<Question> getQuesByStatus()
	{
		List<Question> questions = iQuesAndAnsService.getQuestionsByStatus();
		
		return questions;
	}
	
	@GetMapping("/getAnsByStatus")
	public List<Answer> getAnsByStatus()
	{
		List<Answer> answers = iQuesAndAnsService.getAnswersByStatus();
		
		return answers;
	}
	
}
