package com.example.springbootassessment.task.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.springbootassessment.project.repository.ProjectRepository;
import com.example.springbootassessment.task.repository.TaskRepository;
import com.example.springbootassessment.task.web.dto.TaskDto;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Sql(value = "/data/setup-task-with-project.sql", executionPhase = BEFORE_TEST_METHOD)
class TaskIntegrationTest {

	@Autowired
	// resources on how to use in
	// https://docs.spring.io/spring-framework/reference/testing/webtestclient.html#webtestclient-no-content
	private WebTestClient webTestClient;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	ProjectRepository projectRepository;

	@AfterEach
	void tearDown() {
		taskRepository.deleteAll();
		projectRepository.deleteAll();
	}

	@Test
	@DisplayName("should load all tasks")
	void shouldLoadAllTasks(TestInfo testInfo) {
		System.out.println("Test: " + testInfo.getDisplayName());
		System.out.println("Tasks in DB: " + taskRepository.count());

		List<TaskDto> taskDtoList = webTestClient.get().uri("tasks").exchange().expectStatus().is2xxSuccessful()
				.expectBodyList(TaskDto.class).returnResult().getResponseBody();

		assertThat(taskDtoList).hasSize(5);
	}

	@Test
	@DisplayName("should load task by project id")
	void shouldLoadTasksByProjectId() {
		// given

		// when

		// then
		fail("todo: implement");
	}

	@Test
	@DisplayName("given project id does not exist, when loading tasks by project id, then should return 404")
	void givenProjectIdDoesNotExistWhenLoadingTasksByProjectIdThenShouldReturn404() {
		// given

		// when

		// then
		fail("todo: implement");
	}
}