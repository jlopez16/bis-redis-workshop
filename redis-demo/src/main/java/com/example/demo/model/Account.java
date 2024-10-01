package com.example.demo.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("ledger")
@Data
public class Account implements Serializable {

    @PrimaryKey
    private String accountId;
    private String assetType;
    private String currency;
    private Double balance;
}
