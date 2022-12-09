package com.carlos.estudos.plataforma.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.carlos.estudos.plataforma.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.model.User;
import com.carlos.estudos.plataforma.repository.IUserRepository;
import com.carlos.estudos.plataforma.repository.RecordNotFoundException;
import com.carlos.estudos.plataforma.service.contracts.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository repository;

	public UserServiceImpl(IUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User create(User user) {
		if (isUserNameAvailable(user.getUserName()) && isEmailAvailable(user.getEmail())) {
			return repository.save(user);
		} else {
			return null;
		}
	}

	@Override
	public User update(Integer id, UpdateUserDto data) {
		User user = find(id);
		user.setEmail(data.getEmail());
		user.setUserName(data.getUserName());
		user.setName(data.getName());
		return repository.save(user);
	}

	@Override
	public void delete(Integer id) {
		User user = find(id);
		repository.delete(user);
	}

	@Override
	public List<User> getAll() {
		List<User> list;
		Iterable<User> records = repository.findAll();
		list = StreamSupport.stream(records.spliterator(), false).collect(Collectors.toList());
		return list;
	}

	@Override
	public User find(Integer id) {
		Optional<User> row = this.repository.findById(id);
		if (row.isEmpty()) {
			throw new RecordNotFoundException("Não foi possível encontrar o usuário.");
		}
		return row.get();
	}

	@Override
	public boolean isEmailAvailable(String email) {
		return !repository.findByEmail(email).isPresent();

	}

	@Override
	public boolean isUserNameAvailable(String userName) {
		return !repository.findByUserName(userName).isPresent();
	}

}
