package com.doomsaj.bank_project_spring.domain.account.entity;

import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DateProperties;
import com.doomsaj.bank_project_spring.domain.branch.entity.Branch;
import com.doomsaj.bank_project_spring.domain.customer.entity.Customer;
import com.doomsaj.bank_project_spring.domain.transaction.entity.Transaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long number;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "balance")
    private long balance;

    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions;

    @Embedded
    private DateProperties dates;

    public Account(long number, Branch branch, Customer customer, DateProperties dates) {
        this.number = number;
        this.branch = branch;
        this.customer = customer;
        this.dates = dates;
    }
}

