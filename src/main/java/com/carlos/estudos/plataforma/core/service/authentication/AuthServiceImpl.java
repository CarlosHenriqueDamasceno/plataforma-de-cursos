package com.carlos.estudos.plataforma.core.service.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.carlos.estudos.plataforma.core.service.authentication.contracts.IAuthService;
import com.carlos.estudos.plataforma.user.dto.LoginDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService{
	
	private final AuthenticationConfiguration authenticationConfiguration;
	private final JwtProvider jwtProvider;
	
	@Override
	public String auth(LoginDto data) throws Exception{

		AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();

		Authentication auth = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				data.getUsername(), data.getPassword()
			)
		);
		SecurityContextHolder.getContext().setAuthentication(auth);
		return jwtProvider.generateToken(auth);
	}
}
