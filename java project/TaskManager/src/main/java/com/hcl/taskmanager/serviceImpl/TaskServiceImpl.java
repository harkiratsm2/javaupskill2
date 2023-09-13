package com.hcl.taskmanager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.taskmanager.entity.Task;
import com.hcl.taskmanager.exception.NoTaskExistsException;
import com.hcl.taskmanager.exception.TaskAlreadyExistsException;
import com.hcl.taskmanager.repository.ITaskRepository;
import com.hcl.taskmanager.service.ITaskService;
import com.hcl.taskmanager.to.TaskTO;

@Service
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	ITaskRepository iTaskRepository;

	public String addTask(TaskTO task) {
		
		Task task1 = new Task(0, task.getDescription(), task.getAssignedDate(), task.getStatus(), task.getResolution());
		
		Task taskCheck = iTaskRepository.findByDescription(task.getDescription());
		
		if(taskCheck == null)
		{
			iTaskRepository.save(task1);
		}
		else
		{
			throw new TaskAlreadyExistsException("Task Already Exists with Description "+task.getDescription());
		}
		
		return "Task Created Successfully";
	}

	public List<Task> getAllTasks() {

		return iTaskRepository.findAll();
	}

	public String deleteTask(int taskId) {

		Task task = iTaskRepository.findByTaskId(taskId);
		
		if(task != null)
		{
			iTaskRepository.deleteById(taskId);
		}
		else
		{
			throw new NoTaskExistsException("No Task Exists with Task Id : "+taskId);
		}
		return "Task deleted Successfully";
	}

	public String updateTask(Task task) {

		Task task1 = iTaskRepository.findByTaskId(task.getTaskId());
		
		if(task1 != null)
		{
			iTaskRepository.save(task);
		}
		else
		{
			throw new NoTaskExistsException("No Task Exists with Task Id : "+task.getTaskId());
		}
		return "Task Updated Successfully";
	}

	public Task findTaskById(int taskId) {
		
		Task task = iTaskRepository.findByTaskId(taskId);
		
		if(task == null)
		{
			throw new NoTaskExistsException("No Task Exists with Task Id : "+taskId);
		}
		
		return iTaskRepository.findByTaskId(taskId);
	}

}
