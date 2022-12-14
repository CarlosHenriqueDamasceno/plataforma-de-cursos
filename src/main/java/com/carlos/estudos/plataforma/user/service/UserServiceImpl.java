package com.carlos.estudos.plataforma.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carlos.estudos.plataforma.core.exception.RecordNotFoundException;
import com.carlos.estudos.plataforma.user.dto.CreateUserDto;
import com.carlos.estudos.plataforma.user.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.user.dto.UserOutputDto;
import com.carlos.estudos.plataforma.user.model.User;
import com.carlos.estudos.plataforma.user.repository.IUserRepository;
import com.carlos.estudos.plataforma.user.service.contracts.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

	private final IUserRepository repository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserOutputDto create(CreateUserDto data) {
		if (!isUserNameAvailable(data.getUsername()))
			throw new ValidationException("Nome de usuário já utilizado.");

		if (!isEmailAvailable(data.getEmail()))
			throw new ValidationException("Email já utilizado.");

		User user = new User();
		BeanUtils.copyProperties(data, user);
		user.setPassword(passwordEncoder.encode(data.getPassword()));
		repository.save(user);
		UserOutputDto result = new UserOutputDto();
		BeanUtils.copyProperties(user, result);
		return result;
	}

	@Override
	public UserOutputDto update(Integer id, UpdateUserDto data) {

		if (!isEmailAvailable(data.getEmail(), id))
			throw new ValidationException("Email já utilizado.");

		User user = repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Não foi possível encontrar o usuário."));
		BeanUtils.copyProperties(data, user);
		UserOutputDto result = new UserOutputDto();
		BeanUtils.copyProperties(user, result);
		return result;
	}

	@Override
	public void delete(Integer id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Não foi possível encontrar o usuário."));
		repository.delete(user);
	}

	@Override
	public List<UserOutputDto> getAll() {
		List<UserOutputDto> resultList = new ArrayList<UserOutputDto>();
		List<User> rows = repository.findAll();
		rows.stream().forEach(user -> {
			UserOutputDto temp = new UserOutputDto();
			BeanUtils.copyProperties(user, temp);
			resultList.add(temp);
		});
		return resultList;
	}

	@Override
	public UserOutputDto find(Integer id) {
		Optional<User> row = this.repository.findById(id);
		if (row.isEmpty()) {
			throw new RecordNotFoundException("Não foi possível encontrar o usuário.");
		}
		User user = row.get();
		UserOutputDto result = new UserOutputDto();
		BeanUtils.copyProperties(user, result);
		return result;
	}

	@Override
	public boolean isEmailAvailable(String email, Integer exceptionId) {

		Optional<User> user = repository.findByEmail(email);

		return !user.isPresent() || exceptionId.equals(user.get().getId());
	}

	@Override
	public boolean isEmailAvailable(String email) {
		return !repository.findByEmail(email).isPresent();

	}

	@Override
	public boolean isUserNameAvailable(String username) {
		return !repository.findByUsername(username).isPresent();
	}

}
