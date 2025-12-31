package webtech.foodspotsapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import webtech.foodspotsapp.Entities.Foodspot;
import webtech.foodspotsapp.Repositories.FoodspotRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FoodspotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FoodspotRepository foodspotRepository;

    @Test
    public void testCreateFoodspot() throws Exception {
        Foodspot foodspot = new Foodspot();
        foodspot.setName("Test Spot");

        Foodspot savedFoodspot = new Foodspot();
        savedFoodspot.setId(1L);
        savedFoodspot.setName("Test Spot");

        when(foodspotRepository.save(any(Foodspot.class))).thenReturn(savedFoodspot);

        mockMvc.perform(post("/foodspots")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Test Spot\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Spot"));
    }
}
