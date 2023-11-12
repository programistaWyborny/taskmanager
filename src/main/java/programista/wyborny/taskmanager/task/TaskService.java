package programista.wyborny.taskmanager.task;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import programista.wyborny.taskmanager.user.UserEntity;

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

    public TaskByIdResponse getTasks(Integer id) {
        return taskRepository.findById(id)
                .map(this::getTaskByIdResponse)
                .orElseThrow(TaskNotNoundException::new);
    }

    private TaskResponse getTaskResponse(TaskEntity taskEntity) {
        return new TaskResponse(taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getStatus());
    }

    private TaskByIdResponse getTaskByIdResponse(TaskEntity taskEntity){
        return new TaskByIdResponse(taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getStatus(),
                taskEntity.getUsers());
    }


    public TaskResponse addTask(AddTaskRequest request) {
        TaskEntity taskEntity = new TaskEntity(request.getTitle(), request.getDescription(), request.getStatus());
        TaskEntity savedEntity = taskRepository.save(taskEntity);
        TaskResponse taskResponse = getTaskResponse(savedEntity);
        return taskResponse;
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    public void addUserToTask(AddUserToTaskRequest request) {

    }
}
