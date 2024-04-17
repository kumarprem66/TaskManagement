package com.placement.crash.TastManagement.service;

import com.placement.crash.TastManagement.entity.Task;

import java.util.List;

public interface TasksService {


    List<Task> getAllTasks() ;


    // Method to create a new task
    Task createTask(Task task) ;

    // Method to update an existing task
    Task updateTask(Long taskId, Task taskDetails) ;

    // Method to mark a task as completed
   Task markTaskAsCompleted(Long taskId);

    Task assignTaskToUser( Long taskId, String username);
}
