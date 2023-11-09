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


}
