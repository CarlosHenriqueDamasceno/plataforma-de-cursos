package com.carlos.estudos.plataforma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.estudos.plataforma.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	public Optional<User> findByEmail(String email);
	public Optional<User> findByUserName(String userName);
}
