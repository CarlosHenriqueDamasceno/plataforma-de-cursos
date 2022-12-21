package com.carlos.estudos.plataforma.user.dto;

import com.carlos.estudos.plataforma.user.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {	
	private Integer id;
	private String name;
	private String username; 
	private String email;

	public UserOutputDto(User model){
		id = model.getId();
		name = model.getName();
		username = model.getUsername();
		email = model.getEmail();
	}
}
