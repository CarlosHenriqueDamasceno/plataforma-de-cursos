package com.carlos.estudos.plataforma.controller;

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

import com.carlos.estudos.plataforma.dto.CreateUserDto;
import com.carlos.estudos.plataforma.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.model.User;
import com.carlos.estudos.plataforma.service.contracts.IUserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	private final IUserService service;
	
	public UserController(IUserService service) {
		this.service = service;
	}

	@GetMapping
	public List<User> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public User find(@PathVariable("id") Integer id) {
		return service.find(id);
	}
	
	@PostMapping
	public User create(@Valid @RequestBody CreateUserDto data) {	
		return service.create(data);
	}
	
	@PutMapping("/{id}")
	public User update(@PathVariable("id") Integer id, @Valid @RequestBody UpdateUserDto data) {
		return service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id){
		service.delete(id);
	}
	
}
