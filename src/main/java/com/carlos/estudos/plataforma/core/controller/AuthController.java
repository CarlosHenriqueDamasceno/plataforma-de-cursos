package com.carlos.estudos.plataforma.core.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.estudos.plataforma.core.dto.LoginDto;
import com.carlos.estudos.plataforma.core.service.authentication.contracts.IAuthService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthController {
	
	private final IAuthService service;
	
	@PostMapping("api/v1/auth")
	public String auth(@Valid @RequestBody LoginDto data) throws Exception{
		return service.auth(data);
	}
}
