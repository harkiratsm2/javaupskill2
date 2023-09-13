package com.hcl.doconnect.to;

public class QuestionTO {

	private String question;
	private String topic;
	private String imageUrl;
	private String username;
	
	public QuestionTO() {
		super();
	}

	public QuestionTO(String question, String topic, String imageUrl, String username) {
		super();
		this.question = question;
		this.topic = topic;
		this.imageUrl = imageUrl;
		this.username = username;
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
	
}
