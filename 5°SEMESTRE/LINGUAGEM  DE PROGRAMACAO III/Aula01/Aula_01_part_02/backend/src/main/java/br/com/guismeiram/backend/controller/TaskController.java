package br.com.guismeiram.backend.controller;

import br.com.guismeiram.backend.models.Task;
import br.com.guismeiram.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

}
