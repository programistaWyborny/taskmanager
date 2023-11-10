package programista.wyborny.taskmanager.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskResponse> getTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::getTaskResponse)
                .collect(Collectors.toList());

    }

    private TaskResponse getTaskResponse(TaskEntity taskEntity) {
        return new TaskResponse(taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getStatus());
    }


    public TaskResponse addTask(AddTaskRequest request) {
        TaskEntity taskEntity = new TaskEntity(request.getTitle(), request.getDescription(), request.getStatus());
        TaskEntity savedEntity = taskRepository.save(taskEntity);
        TaskResponse taskResponse = getTaskResponse(savedEntity);
        return taskResponse;
    }
}
