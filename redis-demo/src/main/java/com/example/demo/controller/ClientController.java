package com.example.demo.controller;

import com.example.demo.entity.ClientEntity;
import com.example.demo.model.ModelResponse;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping(value = "/v1/clients")
@Validated
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<ModelResponse> getAllClients() {
        Set<ClientEntity> clients = service.getAllClients();
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), clients, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }

    @PostMapping
    public ResponseEntity<ModelResponse> createClient(@RequestBody ClientEntity client) {
        ClientEntity savedClient = service.saveClient(client);
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), savedClient, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }
}
