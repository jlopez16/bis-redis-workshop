package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.ModelResponse;
import com.example.demo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<ModelResponse> getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        log.info("Accounts retrieved: {}", accounts.size());
        ModelResponse response = ModelResponse.builder()
                .timestamp(LocalDateTime.now())
                .data(accounts)
                .result("Success")
                .build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<ModelResponse> getAccount(@PathVariable("id") String accountId) {
        Account account = accountService.getAccount(accountId);
        ModelResponse response = ModelResponse.builder()
                .timestamp(LocalDateTime.now())
                .data(account)
                .result("Success")
                .build();
        return ResponseEntity.ok().body(response);
    }
}
