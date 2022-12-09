package com.carlos.estudos.plataforma.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.carlos.estudos.plataforma.model.User;

public interface IUserRepository extends CrudRepository<User, Integer>{
	public Optional<User> findByEmail(String email);
	public Optional<User> findByUserName(String userName);
}
