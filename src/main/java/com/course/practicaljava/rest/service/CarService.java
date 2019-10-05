package com.course.practicaljava.rest.service;

import java.util.Arrays;
import java.util.List;

import com.course.practicaljava.rest.domain.Car;

public interface CarService {
	List<String> BRANDS = Arrays.asList("Toyota", "Honda", "Ford");
	List<String> COLORS = Arrays.asList("Red", "Black", "White");
	List<String> TYPES = Arrays.asList("Sedan", "SUV", "MPV");

	Car generateCar();

}
