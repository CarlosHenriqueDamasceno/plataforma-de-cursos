package com.carlos.estudos.plataforma.user.contoller;

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

import com.carlos.estudos.plataforma.user.dto.CreateUserDto;
import com.carlos.estudos.plataforma.user.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.user.dto.UserOutputDto;
import com.carlos.estudos.plataforma.user.service.contracts.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
	
	private final IUserService service;

	@GetMapping
	public List<UserOutputDto> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public UserOutputDto find(@PathVariable("id") Integer id) {
		return service.find(id);
	}
	
	@PostMapping
	public UserOutputDto create(@Valid @RequestBody CreateUserDto data) {	
		return service.create(data);
	}
	
	@PutMapping("/{id}")
	public UserOutputDto update(@PathVariable("id") Integer id, @Valid @RequestBody UpdateUserDto data) {
		return service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id){
		service.delete(id);
	}
	
}
