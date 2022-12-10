package com.carlos.estudos.plataforma.user.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.estudos.plataforma.exception.RecordNotFoundException;
import com.carlos.estudos.plataforma.user.dto.CreateUserDto;
import com.carlos.estudos.plataforma.user.dto.LoginDto;
import com.carlos.estudos.plataforma.user.dto.UpdateUserDto;
import com.carlos.estudos.plataforma.user.model.User;
import com.carlos.estudos.plataforma.user.repository.IUserRepository;
import com.carlos.estudos.plataforma.user.service.authentication.JwtProvider;
import com.carlos.estudos.plataforma.user.service.contracts.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

	private final IUserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationConfiguration authenticationConfiguration;
	private final JwtProvider jwtProvider;

	@Override
	@Transactional
	public User create(CreateUserDto data) throws ValidationException {

		if (isUserNameAvailable(data.getUserName()) && isEmailAvailable(data.getEmail())) {
			
			User user = new User(
				data.getName(),
				data.getUserName(),
				passwordEncoder.encode(data.getPassword()),
				data.getEmail()
			);

			return repository.save(user);
		} else {
			throw new ValidationException("Email ou nome de usuário já utilizado.");
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
		return repository.findAll();
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

	@Override
	public String auth(LoginDto data) throws Exception{

		AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();

		Authentication auth = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				data.getUserName(), data.getPassword()
			)
		);
		SecurityContextHolder.getContext().setAuthentication(auth);
		return jwtProvider.generateToken(auth);
	}
}
