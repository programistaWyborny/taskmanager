package programista.wyborny.taskmanager.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryCustomImpl implements TaskRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public List<TaskEntity> findAllByStatus(Status status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TaskEntity> query = criteriaBuilder.createQuery(TaskEntity.class);
        Root<TaskEntity> root = query.from(TaskEntity.class);

        if (status != null) {
            Predicate predicate = criteriaBuilder.equal(root.get("status"), status);
            query.where(predicate);
        }

        return entityManager.createQuery(query).getResultList();
    }
}
