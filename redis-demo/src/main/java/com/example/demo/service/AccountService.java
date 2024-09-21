package com.example.demo.service;

import com.example.demo.entity.AccountEntity;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Cacheable(value = "accounts")
    public Set<AccountEntity> getAllAccounts(){
        Set<AccountEntity> accounts = new HashSet<>();
        accountRepository.findAll().forEach(accounts::add);
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return accounts;
    }

    public AccountEntity saveAccount(AccountEntity account) {
        return accountRepository.save(account);
    }
}
