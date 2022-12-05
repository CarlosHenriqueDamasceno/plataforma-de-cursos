package com.carlos.estudos.plataforma.service.contracts;

import java.util.List;

import com.carlos.estudos.plataforma.model.User;

public interface IUserService {
	public User create(User user);
	public User update(User user);
	public void delete(User delete);
	public List<User> getAll();
	public User find(Integer id);
}
