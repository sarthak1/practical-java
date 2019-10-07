package com.course.practicaljava.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tire {

	private String manufacturer;

	@JsonProperty("diameter")
	private int size;
	private int price;

}
