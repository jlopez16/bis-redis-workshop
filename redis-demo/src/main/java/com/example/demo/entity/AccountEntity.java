package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@Entity
public class AccountEntity implements Serializable {

    private static final long serialVersionUID = 1786544567L;

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long accountId;
    private double balance;
    private String currency;
    private Long clientId;

}
