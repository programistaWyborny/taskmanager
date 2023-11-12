package programista.wyborny.taskmanager.task;

import lombok.Data;

@Data
public class AddUserToTaskRequest {
    Integer userId;
    Status status;
}
