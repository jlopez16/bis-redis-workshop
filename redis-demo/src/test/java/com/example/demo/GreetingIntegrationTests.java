package com.example.demo;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
public class GreetingIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private GreetingRepository greetingRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        greetingRepository.deleteAll();
    }

    @Test
    public void testGreetingEndpoint() throws Exception {
        mockMvc.perform(get("/api/greeting?name=John"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, John!"));
    }
}
