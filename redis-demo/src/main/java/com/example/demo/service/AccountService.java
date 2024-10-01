package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

}