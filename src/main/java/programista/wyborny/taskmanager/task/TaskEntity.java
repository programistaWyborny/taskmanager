package programista.wyborny.taskmanager.task;

import lombok.*;
import programista.wyborny.taskmanager.user.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "tasks")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String status;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "id",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<UserEntity> courses = new HashSet<>();

    public TaskEntity(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
