package com.carlos.estudos.plataforma.course.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.carlos.estudos.plataforma.course.model.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateCourseDto {
	@NotBlank
	@Length(min = 3, max = 255)
	private String name;
	@NotBlank
	private String description;

	public Course toModel(){
		return new Course(
			null,
			name,
			description
		);
	}
}
