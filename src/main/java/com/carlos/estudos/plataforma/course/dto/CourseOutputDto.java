package com.carlos.estudos.plataforma.course.dto;

import com.carlos.estudos.plataforma.course.model.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseOutputDto {
    private Integer id;
    private String name;
    private String description;

    public CourseOutputDto(Course model){
        id = model.getId();
        name = model.getName();
        description = model.getDescription();
    }
}
