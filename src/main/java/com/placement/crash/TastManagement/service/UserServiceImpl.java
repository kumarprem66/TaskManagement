package com.placement.crash.TastManagement.service;

import com.placement.crash.TastManagement.entity.User;
import com.placement.crash.TastManagement.exception.UserException;

import com.placement.crash.TastManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepo userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;



    // Method to find a user by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new UserException("User does not exist with this username"));
    }

    // Method to create a new user
    public User createUser(User user) {
        // Check if user with given username already exists
        if (findByUsername(user.getUsername()) != null) {
            throw new UserException("Username already exists");
        }

        // Encode the password before saving
//        String encodedPassword = passwordEncoder.encode(password);

        // Create and save the user

        return userRepository.save(user);
    }
}
