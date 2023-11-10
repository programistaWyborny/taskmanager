package programista.wyborny.taskmanager.user;

import lombok.*;

import javax.persistence.*;

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

    public UserEntity(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;

    }

}
