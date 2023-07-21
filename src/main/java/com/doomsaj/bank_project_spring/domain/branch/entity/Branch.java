package com.doomsaj.bank_project_spring.domain.branch.entity;

import com.doomsaj.bank_project_spring.domain.embeddeds.DateProperties;
import com.doomsaj.bank_project_spring.domain.account.entity.Account;
import com.doomsaj.bank_project_spring.domain.bank.entity.Bank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Branch{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany()
    private Set<Account> accounts;

    @Embedded
    private DateProperties dates;

    public Branch(String name, Bank bank, DateProperties dates) {
        this.name = name;
        this.bank = bank;
        this.dates = dates;
    }
}

