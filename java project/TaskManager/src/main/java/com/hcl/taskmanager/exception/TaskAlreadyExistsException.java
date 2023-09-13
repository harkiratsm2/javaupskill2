package com.hcl.taskmanager.exception;

public class TaskAlreadyExistsException extends RuntimeException {

	private String message;

	public TaskAlreadyExistsException() {

	}

	public TaskAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}

}
