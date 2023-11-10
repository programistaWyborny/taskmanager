package programista.wyborny.taskmanager.assignment;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/assignment")
@RequiredArgsConstructor

public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    void addAssignment(@RequestBody AddAssignmentRequest assignmentRequest, @RequestAttribute Integer assidnmentId){

    }

}
