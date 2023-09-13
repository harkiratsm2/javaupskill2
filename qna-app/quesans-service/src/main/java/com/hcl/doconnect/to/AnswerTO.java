package com.hcl.doconnect.to;

public class AnswerTO {
	
	private String answer;
	private String imageUrl;;
	private String username;
	private int quesId;
	
	public AnswerTO() {
		super();
		
	}

	public AnswerTO(String answer, String imageUrl, String username, int quesId) {
		super();
		this.answer = answer;
		this.imageUrl = imageUrl;
		this.username = username;
		this.quesId = quesId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	
}
