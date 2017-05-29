package com.solidarize.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solidarize.model.User;
import com.solidarize.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Integer id){
		return userRepository.findById(id);
	}
    public User findUserByLogin(String login){
    	return userRepository.findByLogin(login);
    }
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public void deleteUser(User user){
		userRepository.delete(user);
	}
	
	public Iterable<User> allUsers(){
		return userRepository.findAll();
	}


}
