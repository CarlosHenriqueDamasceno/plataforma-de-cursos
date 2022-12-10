package com.carlos.estudos.plataforma.user.service.contracts;

import java.util.List;

import javax.validation.ValidationException;

import com.carlos.estudos.plataforma.user.dto.CreateUserDto;
import com.carlos.estudos.plataforma.user.dto.LoginDto;
import com.carlos.estudos.plataforma.user.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.user.model.User;

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