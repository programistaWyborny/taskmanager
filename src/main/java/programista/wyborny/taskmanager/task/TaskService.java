package programista.wyborny.taskmanager.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import programista.wyborny.taskmanager.user.UserEntity;
import programista.wyborny.taskmanager.user.UserNotNoundException;
import programista.wyborny.taskmanager.user.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public List<TaskResponse> getTasks(Status status) {
        return taskRepository.findAllByStatus(status)
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
                taskEntity.getStatus(),
                taskEntity.getDeadline());
    }

    private TaskByIdResponse getTaskByIdResponse(TaskEntity taskEntity) {
        return new TaskByIdResponse(taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getStatus(),
                taskEntity.getDeadline(),
                taskEntity.getUsers());
    }


    public TaskResponse addTask(AddTaskRequest request) {
        TaskEntity taskEntity = new TaskEntity(request.getTitle(), request.getDescription(), request.getStatus(), request.getDeadline());
        TaskEntity savedEntity = taskRepository.save(taskEntity);
        TaskResponse taskResponse = getTaskResponse(savedEntity);
        return taskResponse;
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    public void addUserToTask(Integer taskId, AddUserToTaskRequest request) {

        if ((request.status == null && request.userId == null) ||
                (request.status != null && request.userId != null)){
            throw (new BadRequestException());
        }

        if(request.status == null && request.userId != null){
            TaskEntity taskEntity = taskRepository.findById(taskId)
                    .orElseThrow(() -> new TaskNotNoundException());
            UserEntity userEntity = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new UserNotNoundException());
            taskEntity.getUsers().add(userEntity);
            taskRepository.save(taskEntity);
        }
        if(request.status != null && request.userId == null){
            TaskEntity taskEntity = taskRepository.findById(taskId)
                    .orElseThrow(() -> new TaskNotNoundException());
            taskEntity.setStatus(request.status);
            taskRepository.save(taskEntity);
        }

    }
}
