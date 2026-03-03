package br.com.guismeiram.backend.service;

import br.com.guismeiram.backend.models.Task;
import br.com.guismeiram.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task findById(Long id) {
        Optional<Task> result = taskRepository.findById(id);

        if (result.isPresent()) {
            return result.get();

        }else{
            return result.orElse(null);
        }
    }


    public void delete( Long id) {
        taskRepository.findById(id).ifPresent(task -> taskRepository.delete(task));

    }

    public Task updateTask(Task task, Long id) {
        Task result =  taskRepository.findById(id).orElse(null);

        if(result != null){
            result.setTitle(task.getTitle());
            result.setCompleted(task.isCompleted());
        }


        return taskRepository.save(result);
    }
}
