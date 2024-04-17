package com.placement.crash.TastManagement.controller;

import com.placement.crash.TastManagement.entity.Task;
import com.placement.crash.TastManagement.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TasksService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }

    // API endpoint to create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task),HttpStatus.CREATED);
    }

    // API endpoint to update an existing task
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task taskDetails) {
        return new ResponseEntity<>(taskService.updateTask(taskId, taskDetails),HttpStatus.OK);
    }

    // API endpoint to mark a task as completed
    @PutMapping("/{taskId}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long taskId) {
        return new ResponseEntity<>(taskService.markTaskAsCompleted(taskId), HttpStatus.ACCEPTED);
    }

    // API endpoint to assign a task to a user
    @PostMapping("/{taskId}/assign/{username}")
    public ResponseEntity<Task> assignTaskToUser(@PathVariable Long taskId, @PathVariable String username) {
        return new ResponseEntity<>(taskService.assignTaskToUser(taskId,username),HttpStatus.OK);
    }
    // Add more API endpoints as needed (e.g., for filtering, sorting)
}

