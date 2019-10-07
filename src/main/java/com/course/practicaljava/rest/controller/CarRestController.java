package com.course.practicaljava.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.service.CarService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/car/v1")
@Slf4j
public class CarRestController {

	@Autowired
	private CarService carService;

	private Random random = new Random();

	@GetMapping(path = "/random")
	public Car random() {
		return carService.generateCar();
	}

	@PostMapping(path = "/echo")
	public Car echo(@RequestBody Car car) {

		log.info("This car is :-" + car);
		return carService.generateCar();
	}

	@GetMapping(path = "/random-cars")
	public List<Car> randomCars() {

		List<Car> result = new ArrayList<>();

		for (int i = 0; i < random.nextInt(carService.ADDITIONAL_FEATURES.size()+1); i++) {
			result.add(carService.generateCar());

		}
		return result;
	}

}
