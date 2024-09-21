package com.example.demo.service;

import com.example.demo.entity.ClientEntity;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Set<ClientEntity> getAllClients(){
        Set<ClientEntity> clients = new HashSet<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    public ClientEntity saveClient(ClientEntity client) {
        return clientRepository.save(client);
    }

}
