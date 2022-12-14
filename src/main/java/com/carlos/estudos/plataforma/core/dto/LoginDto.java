package com.carlos.estudos.plataforma.core.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank
    @Length(min = 1, max = 100)
    private String username;
    @NotBlank
    @Length(min = 8, max = 255)
    private String password;
}
