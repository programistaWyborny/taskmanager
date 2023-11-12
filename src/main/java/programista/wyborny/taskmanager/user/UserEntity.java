package programista.wyborny.taskmanager.user;

import lombok.*;
import programista.wyborny.taskmanager.task.TaskEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "users")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;

    @ManyToMany(mappedBy = "users")
    private Set<TaskEntity> tasks = new HashSet<>();

    public UserEntity(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;

    }

}
