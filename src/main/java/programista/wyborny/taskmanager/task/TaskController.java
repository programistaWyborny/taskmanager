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
    List<TaskResponse> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    TaskByIdResponse getTasks(@PathVariable Integer id) {
        return taskService.getTasks(id);
    }

    @PostMapping()
    TaskResponse addTask(@RequestBody AddTaskRequest request) {
        return taskService.addTask(request);
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable Integer id) {
        taskService.delete(id);
    }

    @PatchMapping("/{taskId}")
    void addUserToTask(@PathVariable Integer taskId, @RequestBody AddUserToTaskRequest request) {
        taskService.addUserToTask(taskId, request);
    }


}
