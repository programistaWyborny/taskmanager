package programista.wyborny.taskmanager.task;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    public TaskEntity(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
