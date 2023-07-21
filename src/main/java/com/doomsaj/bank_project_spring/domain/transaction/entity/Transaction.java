package com.doomsaj.bank_project_spring.domain.transaction.entity;

import com.doomsaj.bank_project_spring.domain.embeddeds.DateProperties;
import com.doomsaj.bank_project_spring.domain.account.entity.Account;
import com.doomsaj.bank_project_spring.domain.transaction.consts.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private boolean status;

    private String description;

    @Embedded
    private DateProperties dates;

    public Transaction(double amount, TransactionType type, Account account, DateProperties dates) {
        this.amount = amount;
        this.type = type;
        this.account = account;
        this.dates = dates;
    }
}