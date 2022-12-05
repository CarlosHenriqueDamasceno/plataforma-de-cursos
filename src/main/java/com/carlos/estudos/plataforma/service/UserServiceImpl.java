package com.carlos.estudos.plataforma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carlos.estudos.plataforma.model.User;
import com.carlos.estudos.plataforma.repository.IUserRepository;
import com.carlos.estudos.plataforma.service.contracts.IUserService;

@Service
public class UserServiceImpl implements IUserService
{

	private IUserRepository repository;
	
	public UserServiceImpl(IUserRepository repository) {
		this.repository =  repository;
	}
	
	@Override
	public User create(User user) {
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User delete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
