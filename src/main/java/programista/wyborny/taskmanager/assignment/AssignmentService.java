package programista.wyborny.taskmanager.assignment;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import programista.wyborny.taskmanager.task.TaskService;
import programista.wyborny.taskmanager.user.UserService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final TaskService taskService;
    private final UserService userService;

    @Transactional
    public void addAssignment(Integer userId, Integer taskId){

    }

}
