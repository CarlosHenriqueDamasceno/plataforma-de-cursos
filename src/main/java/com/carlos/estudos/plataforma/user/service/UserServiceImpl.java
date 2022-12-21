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

		User user = data.toModel();
		user.setPassword(passwordEncoder.encode(data.getPassword()));
		repository.save(user);
		return new UserOutputDto(user);
	}

	@Override
	public UserOutputDto update(Integer id, UpdateUserDto data) {
		if (!isEmailAvailable(data.getEmail(), id))
			throw new ValidationException("Email já utilizado.");

		User user = getUserByIdOrThowException(id);
		BeanUtils.copyProperties(data, user);
		return new UserOutputDto(user);
	}

	@Override
	public void delete(Integer id) {
		User user = getUserByIdOrThowException(id);
		repository.delete(user);
	}

	@Override
	public List<UserOutputDto> getAll() {
		List<UserOutputDto> resultList = new ArrayList<>();
		List<User> users = repository.findAll();
		users.stream().forEach(user -> resultList.add(new UserOutputDto(user)));
		return resultList;
	}

	@Override
	public UserOutputDto find(Integer id) {
		User user = getUserByIdOrThowException(id);
		return new UserOutputDto(user);
	}

	@Override
	public boolean isEmailAvailable(String email, Integer idToIgnore) {

		Optional<User> user = repository.findByEmail(email);

		return !user.isPresent() || idToIgnore.equals(user.get().getId());
	}

	@Override
	public boolean isEmailAvailable(String email) {
		return !repository.findByEmail(email).isPresent();

	}

	@Override
	public boolean isUserNameAvailable(String username) {
		return !repository.findByUsername(username).isPresent();
	}


	private User getUserByIdOrThowException(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Não foi possível encontrar o usuário."));
	}
}
