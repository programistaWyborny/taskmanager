package programista.wyborny.taskmanager.task;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_task",
            joinColumns = { @JoinColumn(name = "task_id") },
            inverseJoinColumns =  @JoinColumn(name = "user_id")) @ToString.Exclude
    @JsonManagedReference
    private Set<UserEntity> users;

    public TaskEntity(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
