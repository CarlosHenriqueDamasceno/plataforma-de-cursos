package com.carlos.estudos.plataforma.integrationTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.carlos.estudos.plataforma.model.User;
import com.carlos.estudos.plataforma.service.UserServiceImpl;

@SpringBootTest
public class UserTests {

	@Autowired
	private static UserServiceImpl service;
	private static Integer idFound = 1;
	private static Integer idNotFound = 100;
	private static User newUser;
	private static User createdUser;
	
	@BeforeAll
	public static void setup() {
		newUser = new User();
		newUser.setName("Carlos");
		newUser.setEmail("carlos@teste.com");
		newUser.setUserName("carlos123");
		newUser.setPassword("teste123");
		
		createdUser = new User();
		createdUser.setName("Carlos");
		createdUser.setEmail("carlos@teste.com");
		createdUser.setUserName("carlos123");
		createdUser.setPassword("teste123");
		createdUser.setId(1);
		
		service = Mockito.mock(UserServiceImpl.class);
		Mockito.when(service.create(newUser)).thenReturn(createdUser);
		Mockito.when(service.find(idFound)).thenReturn(createdUser);
		Mockito.when(service.find(idNotFound)).thenReturn(null);
	}
	
	@Test
	public void shouldStoreAUser() {
		assertNotNull(service.create(newUser));
	}
	
}
