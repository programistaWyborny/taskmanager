package programista.wyborny.taskmanager.task;

import lombok.Value;

import java.time.LocalDate;

@Value
public class AddTaskRequest {
    String title;
    String description;
    Status status;
    LocalDate deadline;
}
