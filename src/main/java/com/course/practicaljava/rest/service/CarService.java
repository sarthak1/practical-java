package com.course.practicaljava.rest.service;

import java.util.Arrays;
import java.util.List;

import com.course.practicaljava.rest.domain.Car;

public interface CarService {
	List<String> BRANDS = Arrays.asList("Toyota", "Honda", "Ford", "Mitsubishi", "Chevrolet");
	List<String> COLORS = Arrays.asList("Red", "Black", "White", "Blue", "Silver");
	List<String> TYPES = Arrays.asList("Sedan", "SUV", "MPV");
	List<String> ADDITIONAL_FEATURES = Arrays.asList("GPS", "Alarm", "Sunroof", "Media player", "Leather seats");
	List<String> FUEL_TYPES = Arrays.asList("Petrol", "Electric", "Hybrid");
	List<String> TIRE_MANUFACTURERS = Arrays.asList("Goodyear", "Bridgestone", "Dunlop");

	Car generateCar();

}
