package com.course.practicaljava.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.course.practicaljava.repository.CarElasticRepository;
import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CarElasticDatasource {

	@Autowired
	private CarElasticRepository carElasticRepository;

	@Autowired
	private CarService randomCarService;

	@Autowired
	private RestTemplate restTemplate;

	@EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)

	public void populateData() {
		log.info("Start DELETE");
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:9200/practical-java",
				HttpMethod.DELETE, null, String.class);
		log.info("DELETE result : " + response.getBody());
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			cars.add(randomCarService.generateCar());
		}

		carElasticRepository.saveAll(cars);
		log.info("Car in Elasticsearch : " + carElasticRepository.count());

	}

}
