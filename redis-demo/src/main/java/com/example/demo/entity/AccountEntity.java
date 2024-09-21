package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@ToString
@Entity
@Setter
@NoArgsConstructor
public class AccountEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1786544567L;

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long accountId;
    private double balance;
    private String currency;
    @JsonIgnoreProperties(value = "accounts")
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

}
