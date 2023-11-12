package programista.wyborny.taskmanager.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::getUserResponse)
                .collect(Collectors.toList());
    }

    public UserResponse getUsers(Integer id) {
        return userRepository.findById(id)
                .map(this::getUserResponse)
                .orElseThrow(UserNotNoundException::new);
    }


    private UserResponse getUserResponse(UserEntity userEntity) {
        return new UserResponse(userEntity.getId(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getEmail());
    }

    public UserResponse addUser(AddUserRequest request) {
        UserEntity userEntity = new UserEntity(request.getName(), request.getSurname(),
                request.getEmail());
        UserEntity savedEntity = userRepository.save(userEntity);
        UserResponse userResponse = getUserResponse(savedEntity);
        return userResponse;
    }

    @Transactional
    public void delete(Integer id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(UserNotNoundException::new);
        userEntity.getTasks().forEach(taskEntity -> taskEntity.getUsers().remove(userEntity));
        userEntity.getTasks().clear();
        userRepository.deleteById(id);
    }

}
