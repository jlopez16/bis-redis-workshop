package com.example.demo.controller;

import com.example.demo.entity.AccountEntity;
import com.example.demo.model.ModelResponse;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    private ResponseEntity<ModelResponse> findAll() {
        List<AccountEntity> accounts = accountRepository.findAll();
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), accounts, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }

    @PostMapping
    private ResponseEntity<ModelResponse> save(@RequestBody AccountEntity account) {
        AccountEntity accountEntity = accountRepository.save(account);
        ModelResponse modelResponse = new ModelResponse(LocalDateTime.now(), accountEntity, "Success");
        return ResponseEntity.ok().body(modelResponse);
    }
}
