package com.hcl.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.to.TaskTO;

@Service
public interface ITaskService {

	String addTask(TaskTO task);

	List<Task> getAllTasks();

	String deleteTask(int taskId);

	String updateTask(Task task);

	Task findTaskById(int taskId);

}
