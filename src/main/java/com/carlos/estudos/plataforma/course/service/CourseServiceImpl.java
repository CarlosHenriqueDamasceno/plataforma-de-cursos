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
		Course course = new Course();
		BeanUtils.copyProperties(data, course);
		repository.save(course);
		CourseOutputDto result = new CourseOutputDto();
		BeanUtils.copyProperties(course, result);
		return result;
	}

	@Override
	public CourseOutputDto update(Integer id, UpdateCourseDto data) {
		Course course = repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Não foi possível encontrar o curso."));
		BeanUtils.copyProperties(data, course);
		CourseOutputDto result = new CourseOutputDto();
		BeanUtils.copyProperties(course, result);
		return result;
	}

	@Override
	public void delete(Integer id) {
		Course course = repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Não foi possível encontrar o curso."));
		repository.delete(course);

	}

	@Override
	public List<CourseOutputDto> getAll() {
		List<CourseOutputDto> resultList = new ArrayList<CourseOutputDto>();
		List<Course> rows = repository.findAll();
		rows.stream().forEach(course -> {
			CourseOutputDto temp = new CourseOutputDto();
			BeanUtils.copyProperties(course, temp);
			resultList.add(temp);
		});
		return resultList;
	}

	@Override
	public CourseOutputDto find(Integer id) {
		Course course = repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Não foi possível encontrar o curso."));
		CourseOutputDto result = new CourseOutputDto();
		BeanUtils.copyProperties(course, result);
		return result;
	}

}
