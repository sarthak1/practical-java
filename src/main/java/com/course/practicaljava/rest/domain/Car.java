package com.course.practicaljava.rest.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	private String brand;
	private String color;
	private String type;
	private int price;
	private boolean available;
	private Date firstReleaseDate;

}
