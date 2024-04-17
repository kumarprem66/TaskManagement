package com.placement.crash.TastManagement.service;

import com.placement.crash.TastManagement.entity.Task;
import com.placement.crash.TastManagement.entity.User;
import com.placement.crash.TastManagement.exception.TaskNotFoundException;
import com.placement.crash.TastManagement.exception.UserException;
import com.placement.crash.TastManagement.repository.TaskRepo;
import com.placement.crash.TastManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service

public class TaskServiceImpl implements TasksService{

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;


    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    // Method to create a new task
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    // Method to update an existing task
    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        // Set other fields as needed

        return taskRepo.save(task);
    }

    // Method to mark a task as completed
    public Task markTaskAsCompleted(Long taskId) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(true);

        return taskRepo.save(task);
    }

    public Task assignTaskToUser( Long taskId, String username) {
        Optional<Task> task = taskRepo.findById(taskId);
        if (task.isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }

        // Find the user by username
        Optional<User> user = userRepo.findByUsername(username);
        if (user.isEmpty()) {
            throw new UserException("User not found");
        }

        // Assign the task to the user (you can implement this logic based on your requirements)
        // For example, you can add a field in the Task model to store the assigned user

        // Return the updated task
        task.get().setUser(user.get());
        return task.get();
    }

}
