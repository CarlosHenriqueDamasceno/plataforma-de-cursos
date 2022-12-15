package com.carlos.estudos.plataforma.course.service.contracts;

import java.util.List;

import com.carlos.estudos.plataforma.course.dto.CourseOutputDto;
import com.carlos.estudos.plataforma.course.dto.CreateCourseDto;
import com.carlos.estudos.plataforma.course.dto.UpdateCourseDto;

public interface ICourseService {
	public CourseOutputDto create(CreateCourseDto data);
	public CourseOutputDto update(Integer id, UpdateCourseDto data);
	public void delete(Integer id);
	public List<CourseOutputDto> getAll();
	public CourseOutputDto find(Integer id);
}
