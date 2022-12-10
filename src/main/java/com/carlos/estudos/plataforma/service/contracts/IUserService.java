package com.carlos.estudos.plataforma.service.contracts;

import java.util.List;

import javax.validation.ValidationException;

import com.carlos.estudos.plataforma.dto.CreateUserDto;
import com.carlos.estudos.plataforma.dto.LoginDto;
import com.carlos.estudos.plataforma.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.model.User;

public interface IUserService {
	public User create(CreateUserDto user) throws ValidationException;
	public User update(Integer id, UpdateUserDto data);
	public void delete(Integer id);
	public List<User> getAll();
	public User find(Integer id);
	public boolean isEmailAvailable(String email);
	public boolean isUserNameAvailable(String userName);
	public String auth(LoginDto data) throws Exception;
}