package com.hcl.doconnect.to;

import java.util.List;

import com.hcl.doconnect.entity.Answer;

public class QuesAndAnsTO {
	
	private int id;
	private String question;
	private String topic;
	private String imageUrl;
	private String username;
	private String status;
	
	List<Answer> answers;

	public QuesAndAnsTO() {
		super();

	}

	public QuesAndAnsTO(int id, String question, String topic, String imageUrl, String username, String status,
			List<Answer> answers) {
		super();
		this.id = id;
		this.question = question;
		this.topic = topic;
		this.imageUrl = imageUrl;
		this.username = username;
		this.status = status;
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}
