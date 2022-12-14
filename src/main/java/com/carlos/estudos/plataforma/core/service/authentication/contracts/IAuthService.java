package com.carlos.estudos.plataforma.core.service.authentication.contracts;

import com.carlos.estudos.plataforma.user.dto.LoginDto;

public interface IAuthService {
	public String auth(LoginDto data) throws Exception;
}
