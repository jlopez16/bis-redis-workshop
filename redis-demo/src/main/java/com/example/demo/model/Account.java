package com.example.demo.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("ledger")
@Data
public class Account {

    @PrimaryKey
    private String accountId;
    private String assetType;
    private String currency;
    private Double balance;
}
