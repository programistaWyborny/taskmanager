package programista.wyborny.taskmanager.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    UserResponse getUsers(@PathVariable Integer id) {
        return userService.getUsers(id);
    }

    @PostMapping()
    UserResponse addUser(@RequestBody AddUserRequest request) {
        return userService.addUser(request);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }


}
