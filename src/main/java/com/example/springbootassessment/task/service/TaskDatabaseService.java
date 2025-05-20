package com.example.springbootassessment.task.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springbootassessment.task.domain.Task;
import com.example.springbootassessment.task.domain.mapper.TaskEntityMapper;
import com.example.springbootassessment.task.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@Profile("db")
@RequiredArgsConstructor
public class TaskDatabaseService implements TaskService {

	private final TaskRepository taskRepository;
	private final TaskEntityMapper taskEntityMapper;

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll().stream().map(taskEntityMapper::map).toList();
	}

	@Override
	public List<Task> findAllByProjectId(Long projectId) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
