package com.hcl.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.taskmanager.entity.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

	Task findByTaskId(int taskId);

	Task findByDescription(String description);

}
