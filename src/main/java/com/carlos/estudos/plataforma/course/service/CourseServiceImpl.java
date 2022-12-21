package com.carlos.estudos.plataforma.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.carlos.estudos.plataforma.core.exception.RecordNotFoundException;
import com.carlos.estudos.plataforma.course.dto.CourseOutputDto;
import com.carlos.estudos.plataforma.course.dto.CreateCourseDto;
import com.carlos.estudos.plataforma.course.dto.UpdateCourseDto;
import com.carlos.estudos.plataforma.course.model.Course;
import com.carlos.estudos.plataforma.course.repository.CourseRepository;
import com.carlos.estudos.plataforma.course.service.contracts.ICourseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements ICourseService {

	private final CourseRepository repository;

	@Override
	public CourseOutputDto create(CreateCourseDto data) {
		Course course = data.toModel();
		repository.save(course);
		return new CourseOutputDto(course);
	}

	@Override
	public CourseOutputDto update(Integer id, UpdateCourseDto data) {
		Course course = getCourseByIdOrThowException(id);
		BeanUtils.copyProperties(data, course);
		repository.save(course);
		return new CourseOutputDto(course);
	}

	@Override
	public void delete(Integer id) {
		Course course = getCourseByIdOrThowException(id);
		repository.delete(course);

	}

	@Override
	public List<CourseOutputDto> getAll() {
		List<CourseOutputDto> resultList = new ArrayList<>();
		List<Course> rows = repository.findAll();
		rows.stream().forEach(course -> resultList.add(new CourseOutputDto(course)));
		return resultList;
	}

	@Override
	public CourseOutputDto find(Integer id) {
		Course course = getCourseByIdOrThowException(id);
		return new CourseOutputDto(course);
	}

	private Course getCourseByIdOrThowException(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Não foi possível encontrar o curso."));
	}

}
