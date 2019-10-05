package com.course.practicaljava.rest.controller;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class DefaultRestController {

	@GetMapping("/welcome")
	public String welcome() {
		log.info(String.join("", "This is ", "Spring BOOT ", "REST API"));
		return "welcome to Spring Boot";
	}

	@GetMapping("/time")
	public String time() {
		return LocalTime.now().toString();
	}

}
