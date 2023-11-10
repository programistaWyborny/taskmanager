package programista.wyborny.taskmanager.user;

import lombok.Value;

@Value
public class AddUserRequest {
    String name;
    String surname;
    String email;
}
