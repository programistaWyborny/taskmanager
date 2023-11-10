package programista.wyborny.taskmanager.task;

import lombok.Value;

@Value
public class AddTaskRequest {
    String title;
    String description;
    String status;
}
