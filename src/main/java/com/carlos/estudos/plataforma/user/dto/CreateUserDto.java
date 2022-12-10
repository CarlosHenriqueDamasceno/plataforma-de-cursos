package com.carlos.estudos.plataforma.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotBlank
    @Length(min = 1, max = 100)
	private String name;
    @NotBlank
    @Length(min = 1, max = 100)
	private String userName; 
	@NotBlank
    @Length(min = 1, max = 255)
    @Email
    private String email;
    @NotBlank
    @Length(min = 8, max = 255)
    private String password;
}
