package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/api/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting("Hello, " + name + "!");
        greetingRepository.save(greeting);
        return greeting.getContent();
    }

    @GetMapping("/api/greetings")
    public List<Greeting> greetings() {
        return greetingRepository.findAll();
    }

    @PostMapping("/api/greeting")
    public Greeting createGreeting(@RequestParam String content) {
        Greeting greeting = new Greeting(content);
        return greetingRepository.save(greeting);
    }
}