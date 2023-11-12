package programista.wyborny.taskmanager.task;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    List<TaskResponse> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping()
    TaskResponse addTask(@RequestBody AddTaskRequest request){
        return taskService.addTask(request);
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Integer id){
        taskService.delete(id);
    }
    


}
