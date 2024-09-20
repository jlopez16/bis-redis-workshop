package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTests {

    @Test
    public void testGreetingConstructor() {
        Greeting greeting = new Greeting("Hello, Test!");
        assertEquals("Hello, Test!", greeting.getContent());
    }

    @Test
    public void testGreetingSettersAndGetters() {
        Greeting greeting = new Greeting();
        greeting.setContent("Test Content");
        assertEquals("Test Content", greeting.getContent());
    }
}