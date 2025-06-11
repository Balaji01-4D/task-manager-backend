package com.balaji.tasks.service;

import com.balaji.tasks.model.Task;
import com.balaji.tasks.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    private final TaskRepo repo;


    TaskService(TaskRepo repo){
        this.repo = repo;
    }

    public List<Task> getAllTasks() {
        return repo.findAll();

    }

    public Task addTask(Task task) {
        return repo.save(task);
    }

    public Task updateTask(Task task) {
        return repo.save(task);
    }

    public Task getTaskById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }

    public List<Task> searchByTitle(String query) {
        return repo.searchByTitle(query);
    }

    public List<Task> searchByPriority(int priorityLevel) {
        return repo.searchByPriority(priorityLevel);
    }
}
