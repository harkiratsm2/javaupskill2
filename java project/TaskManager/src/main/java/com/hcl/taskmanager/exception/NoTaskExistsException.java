package com.hcl.taskmanager.exception;

public class NoTaskExistsException extends RuntimeException {

	private String message;

	public NoTaskExistsException() {

	}

	public NoTaskExistsException(String message) {
		super(message);
		this.message = message;
	}

}
