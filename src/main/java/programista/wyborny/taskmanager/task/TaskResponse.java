package programista.wyborny.taskmanager.task;

import lombok.Value;

import java.time.LocalDate;

@Value
public class TaskResponse {
    int id;
    String title;
    String description;
    Status status;
    LocalDate deadline;
}
