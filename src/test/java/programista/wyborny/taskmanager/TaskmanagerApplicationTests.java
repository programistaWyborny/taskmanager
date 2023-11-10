package programista.wyborny.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import programista.wyborny.taskmanager.task.TaskRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureMockMvc
@SpringBootTest(properties = "spring.config.name=application-test")
class TaskmanagerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void getTasksTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("zadanie1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("zadanie2"));
    }


    @Test
    public void postTasksTest() throws Exception {

        // Wykonanie żądania POST
        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "        \"title\": \"zadanie80\",\n" +
                                "        \"description\": \"Szybko\",\n" +
                                "        \"status\": \"to do\"\n" +
                                "    }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("zadanie80"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Szybko"));

    }

    @Test
    public void deleteTaskTest() throws Exception {
        assertFalse(taskRepository.findById(5).isEmpty());

        mockMvc.perform(MockMvcRequestBuilders.delete("/tasks/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        assertTrue(taskRepository.findById(5).isEmpty());
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void postUserTest() throws Exception {

        // Wykonanie żądania POST
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "        \"name\": \"Mariusz\",\n" +
                                "        \"surname\": \"Pudzian\",\n" +
                                "        \"email\": \"pudzian@mariusz.com\"\n" +
                                "    }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Mariusz"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Pudzian"));

    }


}

