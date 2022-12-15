package com.carlos.estudos.plataforma.course.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(length = 255, nullable = false)
	private String name;
	@Column(columnDefinition="TEXT")
	private String description;
	
	/*
	 * @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) private
	 * List<Student> students;
	 */
}
