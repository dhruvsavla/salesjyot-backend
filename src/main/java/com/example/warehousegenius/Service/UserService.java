package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.User;
import com.example.warehousegenius.Repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByUserEmailAndAndPassword(email, password);
    }
}

