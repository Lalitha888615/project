package com.capg.service;
import java.util.List;

import com.capg.entity.User;
import com.capg.exception.UserAlreadyExistsException;
import com.capg.exception.UserNotFoundException;

public interface UserService {
	public User addUser(User user)throws UserAlreadyExistsException;
	public User updateUser(User user);
	public User deleteUser(long userId);
	public User getUser(long userId) throws UserNotFoundException;
	List<User> getAllUsers();
	
}

