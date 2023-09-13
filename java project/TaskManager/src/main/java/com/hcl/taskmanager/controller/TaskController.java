package com.hcl.taskmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.exception.ErrorResponse;
import com.hcl.taskmanager.exception.TaskAlreadyExistsException;
import com.hcl.taskmanager.service.ITaskService;
import com.hcl.taskmanager.to.TaskTO;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:3000/")
public class TaskController {
	
	@Autowired
	ITaskService iTaskService;
	
	@PostMapping("/add")
	public String addUser(@Valid @RequestBody TaskTO task)
	{
		String addStatus = iTaskService.addTask(task);
		
		return addStatus;
	}
	
	@DeleteMapping("/delete/{taskId}")
	public String deleteUser(@PathVariable int taskId)
	{
		String deleteString = iTaskService.deleteTask(taskId);
		
		return deleteString;
	}
	
	@PutMapping("/update")
	public String updateUser(@Valid @RequestBody Task task)
	{
		String updateStatus = iTaskService.updateTask(task);
		
		return updateStatus;
	}
	
	@GetMapping("/getAllTasks")
	public List<Task> getAllTasks()
	{
		List<Task> tasks = iTaskService.getAllTasks();
		
		return tasks;
	}
	
	@GetMapping("findById/{taskId}")
	public Task findTaskById(@PathVariable int taskId)
	{
		Task task = iTaskService.findTaskById(taskId);
		
		return task;
	}
	
	@ExceptionHandler(value = TaskAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleTaksAlreadyExistsException(TaskAlreadyExistsException ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

}
