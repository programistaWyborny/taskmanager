package programista.wyborny.taskmanager.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    UserResponse addUser(@RequestBody AddUserRequest request){
        return userService.addUser(request);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }


}
