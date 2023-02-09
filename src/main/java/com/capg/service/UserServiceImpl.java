package com.capg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.User;
import com.capg.exception.UserAlreadyExistsException;
import com.capg.exception.UserNotFoundException;

import com.capg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
    	if(userRepository.existsById(user.getUserId())) {
            throw new UserAlreadyExistsException();
        }
    return userRepository.save(user);

    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    @Override
    public User getUser(long userId) throws UserNotFoundException{
    User use;
    if(userRepository.findById(userId).isEmpty()) {
        throw new UserNotFoundException();
    }
    else {
        use=userRepository.findById(userId).get();
    }
    return use;
    }

    @Override
    public List<User> getAllUsers() {
    	return userRepository.findAll();
    	 
    }
//    List<User> users=
//    List<User> findAll();

	
}


