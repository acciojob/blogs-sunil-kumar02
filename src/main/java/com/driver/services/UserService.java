package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogService blogService;

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int userId){
//        User user=userRepository3.findById(userId).get();
//        userRepository3.delete(user);
        userRepository.deleteById(userId);
    }
    public void UpdateUser(User user){
        userRepository.save(user);
    }

    public User findUserByUsername(String username){

        return userRepository.findByUsername(username);
    }
}