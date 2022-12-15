package com.carlos.estudos.plataforma.course.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCourseDto {
	@NotBlank
	@Length(min = 3, max = 255)
	private String name;
	@NotBlank
	private String description;
}
