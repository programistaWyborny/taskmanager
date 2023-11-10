package programista.wyborny.taskmanager.user;

import lombok.Value;

@Value
public class UserResponse {
    int id;
    String name;
    String surname;
    String email;
}
