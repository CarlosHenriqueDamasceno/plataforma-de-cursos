package com.carlos.estudos.plataforma.repository;

import org.springframework.data.repository.CrudRepository;

import com.carlos.estudos.plataforma.model.User;

public interface IUserRepository extends CrudRepository<User, Integer>{

}
