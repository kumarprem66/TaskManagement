package com.placement.crash.TastManagement.service;

import com.placement.crash.TastManagement.entity.User;
import com.placement.crash.TastManagement.exception.UserException;

public interface UserService {

    User findByUsername(String username);

    // Method to create a new user
    User createUser(User user);

}
