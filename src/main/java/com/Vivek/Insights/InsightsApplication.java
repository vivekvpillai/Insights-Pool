package com.Vivek.Insights;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
@RestController
public class InsightsApplication {
	@Autowired
	private ObjectRepository objectRepository;

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(InsightsApplication.class, args);
		// UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);

		User user = new User("vivek");
		Object test = new Object("StoryTeller","Visits", 100, user);
		Object item = new Object("Portfolio", "Visits", 20, user);
		List<Object> objects = Arrays.asList(test, item);
		user.setObject(objects);
		// userRepository.save(user);
	}

	@GetMapping("/hello")
	public String hello() {return "Hello!";
	}

		@GetMapping("/objects")
	public Iterable<Object> index() {
		return objectRepository.findAll();
	}

	@PostMapping("/objects")
	public Iterable<Object> create (@RequestBody Object objectData) {
		objectRepository.save(objectData);
		System.out.println(objectData);
		return objectRepository.findAll();
	}

	@DeleteMapping("/objects/{id}")
	public Iterable<Object> delete(@PathVariable int id) {
		objectRepository.deleteById(id);
		return objectRepository.findAll();
	}

	@PutMapping("/objects/{id}")
	public Iterable<Object> update(@PathVariable int id, @RequestBody Object objectData) {
		objectData.setId(id);
		objectRepository.save(objectData);
		return objectRepository.findAll();
	}

}
