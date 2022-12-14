package com.carlos.estudos.plataforma.user.service.contracts;

import java.util.List;

import com.carlos.estudos.plataforma.user.dto.CreateUserDto;
import com.carlos.estudos.plataforma.user.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.user.dto.UserOutputDto;

public interface IUserService {
	public UserOutputDto create(CreateUserDto data);
	public UserOutputDto update(Integer id, UpdateUserDto data);
	public void delete(Integer id);
	public List<UserOutputDto> getAll();
	public UserOutputDto find(Integer id);
	public boolean isEmailAvailable(String email, Integer exceptionId);
	public boolean isEmailAvailable(String email);
	public boolean isUserNameAvailable(String username);
}