package programista.wyborny.taskmanager.task;

import java.util.List;


public interface TaskRepositoryCustom {
    List<TaskEntity> findAllByStatus(Status status);
}
