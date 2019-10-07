package com.course.practicaljava.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Engine {
	@NonNull
	private String fuelType;
	@NonNull
	private Integer horsePower;
	@JsonIgnore
	private String color;
	@JsonIgnore
	private String serialNumber;

}
