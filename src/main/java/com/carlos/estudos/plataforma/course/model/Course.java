package com.carlos.estudos.plataforma.course.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.carlos.estudos.plataforma.student.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	@Column(name="description", columnDefinition="TEXT")
	private String description;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Student> students;
}
