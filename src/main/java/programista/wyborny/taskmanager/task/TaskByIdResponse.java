package programista.wyborny.taskmanager.task;

import lombok.Value;
import programista.wyborny.taskmanager.user.UserEntity;

import java.time.LocalDate;
import java.util.Set;

@Value
public class TaskByIdResponse {
    int id;
    String title;
    String description;
    Status status;
    LocalDate deadline;
    Set<UserEntity> users;
}
