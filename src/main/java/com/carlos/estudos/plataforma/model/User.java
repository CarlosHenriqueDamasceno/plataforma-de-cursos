package com.carlos.estudos.plataforma.model;

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
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "userName", length = 100, nullable = false, unique = true)
	private String userName;
	@Column(name = "password", length = 255, nullable = false)
	private String password; 
	@Column(name = "email", length = 255)
	private String email;
	
	public User(String name, String userName, String password, String email) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
}
