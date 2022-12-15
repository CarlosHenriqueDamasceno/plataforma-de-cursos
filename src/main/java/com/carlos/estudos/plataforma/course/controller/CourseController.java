package com.carlos.estudos.plataforma.course.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.estudos.plataforma.course.dto.CourseOutputDto;
import com.carlos.estudos.plataforma.course.dto.CreateCourseDto;
import com.carlos.estudos.plataforma.course.dto.UpdateCourseDto;
import com.carlos.estudos.plataforma.course.service.contracts.ICourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/courses")
@AllArgsConstructor
public class CourseController {
	
	private final ICourseService service;

	@GetMapping
	public List<CourseOutputDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public CourseOutputDto find(@PathVariable("id") Integer id) {
		return service.find(id);
	}
	
	@PostMapping
	public CourseOutputDto create(@Valid @RequestBody CreateCourseDto data) {	
		return service.create(data);
	}
	
	@PutMapping("/{id}")
	public CourseOutputDto update(@PathVariable("id") Integer id, @Valid @RequestBody UpdateCourseDto data) {
		return service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id){
		service.delete(id);
	}
}
