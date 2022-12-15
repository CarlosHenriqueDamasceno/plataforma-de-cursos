package com.carlos.estudos.plataforma.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.estudos.plataforma.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
