package com.balaji.tasks.controller;

import com.balaji.tasks.model.Task;
import com.balaji.tasks.service.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TaskController {

    private final TaskService service;

    TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTasks(),HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return new ResponseEntity<>(service.addTask(task), HttpStatus.OK);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        Task result = service.getTaskById(id);
        if (result != null)
            return ResponseEntity.ok(result);
        else
            return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable int taskId, @RequestBody Task task){
        return ResponseEntity.ok(service.updateTask(task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        service.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tasks/search")
    public ResponseEntity<List<Task>> searchByTitle(@RequestParam String query){
        System.out.println(query);
        List<Task> results = service.searchByTitle(query);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/tasks/priority/{priority}")
    public ResponseEntity<List<Task>> searchByPriority(@PathVariable("priority") int priorityLevel){
        List<Task> results = service.searchByPriority(priorityLevel);
        return ResponseEntity.ok(results);
    }
}
