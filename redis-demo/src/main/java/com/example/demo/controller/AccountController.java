package com.example.demo.controller;

import com.example.demo.entity.AccountEntity;
import com.example.demo.model.ModelResponse;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping(path = "/v1/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    private ResponseEntity<ModelResponse> findAll() {
        Set<AccountEntity> accounts = service.getAllAccounts();
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), accounts, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }

    @PostMapping
    private ResponseEntity<ModelResponse> save(@RequestBody AccountEntity account) {
        AccountEntity accountEntity = service.saveAccount(account);
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), accountEntity, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }
}
