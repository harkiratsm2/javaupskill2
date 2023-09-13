package com.hcl.taskmanager.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	@NotEmpty
	@Size(min = 4, message = "Description must be min of 4 characters")
	private String description;
	
	@NotNull(message = "Date is not Valid")
	private LocalDate assignedDate;
	
	@NotEmpty(message = "Status is not Valid")
	private String status;
	
	@NotEmpty(message = "Resolution is not Valid")
	private String resolution;

	public Task() {
		super();
	}

	public Task(int taskId, String description, LocalDate assignedDate, String status, String resolution) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.assignedDate = assignedDate;
		this.status = status;
		this.resolution = resolution;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

}
