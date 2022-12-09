package com.carlos.estudos.plataforma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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
	
	public User() {}
	
	public User(Integer id, String name, String userName, String password, String email) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public User(String name, String userName, String password, String email) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", email="
				+ email + "]";
	}
	
	
}
