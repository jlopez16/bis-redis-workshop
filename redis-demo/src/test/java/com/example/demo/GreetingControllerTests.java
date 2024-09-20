package com.example.demo;

import com.example.demo.controller.GreetingController;
import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingRepository greetingRepository;

    @BeforeEach
    public void setup() {
        // You might need to set up your mock behavior here if using @MockBean
    }

    @Test
    public void testGreetingEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/greeting?name=John"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, John!"));
    }
}
