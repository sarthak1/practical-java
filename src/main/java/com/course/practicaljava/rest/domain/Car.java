package com.course.practicaljava.rest.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Document(indexName = "practical-java", type = "car")
public class Car {

	@Id
	private String id;
	@NonNull
	private String brand;
	@NonNull
	private String color;
	@NonNull
	private String type;
	@NonNull
	private Integer price;
	@NonNull
	private Boolean available;

	@NonNull
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "Asia/Jakarta")
	@Field(type = FieldType.Date, format = DateFormat.date_time)
	private Date firstReleaseDate;

	@NonNull
	@JsonInclude(value = Include.NON_EMPTY)
	private List<String> additionalFeatures;

	@NonNull
	@JsonUnwrapped
	private Engine engine;

	@NonNull
	private List<Tire> compatibleTires;

	@NonNull
	@JsonInclude(value = Include.NON_EMPTY)
	private String secretFeature;

}
