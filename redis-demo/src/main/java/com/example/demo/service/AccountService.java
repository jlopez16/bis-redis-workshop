package com.example.demo.service;

import com.example.demo.config.DatabaseCacheConfig;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Cacheable(value = DatabaseCacheConfig.CACHE_NAME, key = "#id")
    public Account getAccount(String id) {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

}