package com.capg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.User;
import com.capg.exception.UserAlreadyExistsException;
import com.capg.exception.UserNotFoundException;
import com.capg.service.UserService;

@RestController
public class UserController {

@Autowired
UserService userService;

//@PostMapping("/users")
//public User addUser(@RequestBody User user) {
//	return userService.addUser(user);
//}
@PostMapping("/users")
public ResponseEntity addUser(@RequestBody User user) throws UserAlreadyExistsException {
    User use= this.userService.addUser(user);
    return new ResponseEntity(use,HttpStatus.CREATED);
}

@PutMapping("/users")
public User updateUser(@RequestBody User user)throws UserAlreadyExistsException {
	return userService.updateUser(user);
}

@DeleteMapping("/users/{userId}")
public User deleteUser(@PathVariable long userId) {
	return userService.deleteUser(userId);
}

@GetMapping("/users/{userId}")
public ResponseEntity getUserById(@PathVariable long userId) throws UserNotFoundException {
        return new ResponseEntity(this.userService.getUser(userId),HttpStatus.OK);
	
	
}

@GetMapping("/users")
public List<User> getAllUsers(){
	return userService.getAllUsers();
}
}




