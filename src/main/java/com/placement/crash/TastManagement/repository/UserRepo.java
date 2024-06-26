package com.placement.crash.TastManagement.repository;

import com.placement.crash.TastManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
