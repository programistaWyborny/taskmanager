package programista.wyborny.taskmanager.task;

import lombok.Value;

@Value
public class TaskResponse {
    int id;
    String title;
    String description;
    String status;
}
