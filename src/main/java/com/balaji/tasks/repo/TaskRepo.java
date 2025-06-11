package com.balaji.tasks.repo;

import com.balaji.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t " +
            "WHERE t.title LIKE LOWER(CONCAT('%',:keyword,'%'))")
    List<Task> searchByTitle(String keyword);


    @Query("SELECT t FROM Task t " +
            "WHERE t.priorityLevel = :priorityLevel")
    List<Task> searchByPriority(int priorityLevel);
}
