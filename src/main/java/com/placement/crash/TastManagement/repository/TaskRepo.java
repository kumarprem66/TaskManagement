package com.placement.crash.TastManagement.repository;

import com.placement.crash.TastManagement.entity.Task;
import com.placement.crash.TastManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task,Long> {

    List<Task> findByUser(User user);
}
