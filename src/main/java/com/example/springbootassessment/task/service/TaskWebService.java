package com.example.springbootassessment.task.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springbootassessment.task.domain.Task;

import lombok.RequiredArgsConstructor;

@Primary
@Profile("web")
@Service
@RequiredArgsConstructor
public class TaskWebService implements TaskService {

	@Override
	public List<Task> findAll() {
		throw new RuntimeException("Task Webservice is currently not supported");
	}

	@Override
	public List<Task> findAllByProjectId(Long projectId) {
		throw new RuntimeException("Task Webservice is currently not supported");
	}
}
