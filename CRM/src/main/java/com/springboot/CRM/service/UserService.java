package com.springboot.CRM.service;

import com.springboot.CRM.model.User;
import com.springboot.CRM.repository.UserRepository;
import com.springboot.CRM.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

   
    public User saveUser(User user) {
        return userRepository.save(user);
    }

   
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    public User getUserById(int id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}