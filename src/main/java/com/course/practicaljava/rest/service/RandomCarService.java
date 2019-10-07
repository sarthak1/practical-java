package com.course.practicaljava.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.domain.Engine;
import com.course.practicaljava.rest.domain.Tire;
import com.course.practicaljava.util.RandomDateUtil;

@Service
public class RandomCarService implements CarService {
	private Random random = new Random();

	@Override
	public Car generateCar() {
		String randomBrand = BRANDS.get(random.nextInt(BRANDS.size()));
		String randomColor = COLORS.get(random.nextInt(COLORS.size()));
		String randomType = TYPES.get(random.nextInt(TYPES.size()));
		boolean randomAvailable = random.nextBoolean();
		int randomPrice = 5000 + random.nextInt(7001);
		Date randomFirstReleaseDate = RandomDateUtil.generateRandomDate();

		int randomCount = random.nextInt(ADDITIONAL_FEATURES.size());
		List<String> additionalFeatures = new ArrayList<>();

		for (int i = 1; i <= randomCount; i++) {
			additionalFeatures.add(ADDITIONAL_FEATURES.get(i - 1));
		}

		String randomFuelType = FUEL_TYPES.get(random.nextInt(FUEL_TYPES.size()));
		int randomHorsepower = 100 + random.nextInt(121);
		Engine randomEngine = new Engine(randomFuelType, randomHorsepower);

		List<Tire> randomCompatibleTires = new ArrayList<>();
		for (int i = 0; i < TIRE_MANUFACTURERS.size(); i++) {
			String tireManufacturer = TIRE_MANUFACTURERS.get(random.nextInt(TIRE_MANUFACTURERS.size()));
			int tireSize = 15 + random.nextInt(TIRE_MANUFACTURERS.size());
			int tirePrice = 200 + random.nextInt(201);

			Tire randomTire = new Tire(tireManufacturer, tireSize, tirePrice);
			randomCompatibleTires.add(randomTire);

		}

		if (random.nextBoolean()) {
			return new Car(randomBrand, randomColor, randomType, randomPrice, randomAvailable, randomFirstReleaseDate,
					additionalFeatures, randomEngine, randomCompatibleTires, "Can fly");
		}

		return new Car(randomBrand, randomColor, randomType, randomPrice, randomAvailable, randomFirstReleaseDate,
				additionalFeatures, randomEngine, randomCompatibleTires, null);
	}

}
