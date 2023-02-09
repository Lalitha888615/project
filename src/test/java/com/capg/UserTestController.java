package com.capg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.entity.User;
import com.capg.repository.UserRepository;
import com.capg.service.UserService;

public class UserTestController {
	@Autowired
	private UserService userservice;
	
	@MockBean
	private UserRepository userrepository;
	@Test
	public void getAllUsersTest() {
		when(userrepository.findAll()).thenReturn(Stream.of(new User(1,"Alekhya","ale@gmail.com",799,'F',"ale@123")).collect(Collectors.toList()));
		assertEquals(1,userservice.getAllUsers().size());
	}

}
