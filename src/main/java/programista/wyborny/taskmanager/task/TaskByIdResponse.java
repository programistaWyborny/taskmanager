package programista.wyborny.taskmanager.task;

import lombok.Value;
import programista.wyborny.taskmanager.user.UserEntity;

import java.util.Set;

@Value
public class TaskByIdResponse {
    int id;
    String title;
    String description;
    Status status;
    Set<UserEntity> users;
}
