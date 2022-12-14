package com.carlos.estudos.plataforma.core.service.authentication.contracts;

import com.carlos.estudos.plataforma.core.dto.LoginDto;

public interface IAuthService {
	public String auth(LoginDto data) throws Exception;
}
