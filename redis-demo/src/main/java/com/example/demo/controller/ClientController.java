package com.example.demo.controller;

import com.example.demo.entity.ClientEntity;
import com.example.demo.model.ModelResponse;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/clients")
@Validated
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<ModelResponse> getAllClients() {
        List<ClientEntity> clients = this.clientRepository.findAll();
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), clients, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }

    @PostMapping
    public ResponseEntity<ModelResponse> createClient(@RequestBody ClientEntity client) {
        ClientEntity savedClient = this.clientRepository.save(client);
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), savedClient, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }
}
