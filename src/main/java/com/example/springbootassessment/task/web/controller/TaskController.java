package com.example.springbootassessment.task.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootassessment.task.service.TaskService;
import com.example.springbootassessment.task.web.dto.TaskDto;
import com.example.springbootassessment.task.web.mapper.TaskMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

	// todo: inject the task service, that loads the tasks from the database
	/*
	 * there are two implementations of the same TaskService interface, we need to
	 * ensure that the right one is used by spring DI here!
	 */
	private final TaskService taskService;
	private final TaskMapper taskMapper;

//	@Autowired
//	public TaskController(TaskService taskService, TaskMapper taskMapper) {
//		super();
//		this.taskService = taskService;
//		this.taskMapper = taskMapper;
//	}

	@GetMapping
	public ResponseEntity<List<TaskDto>> getAllTasks() {
		List<TaskDto> taskDtoList = taskService.findAll().stream().map(taskMapper::map).toList();
		return ResponseEntity.ok(taskDtoList);
	}

	@GetMapping("/{projectId}")
	public ResponseEntity<List<TaskDto>> getTasksByProjectId(@PathVariable Long projectId) {
		throw new RuntimeException("todo: implement");
	}
}
