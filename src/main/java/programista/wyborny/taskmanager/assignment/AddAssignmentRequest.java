package programista.wyborny.taskmanager.assignment;


import lombok.Value;

@Value
class AddAssignmentRequest {
    Integer userId;
    Integer taskId;
}
