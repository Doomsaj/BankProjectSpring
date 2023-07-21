package com.doomsaj.bank_project_spring.domain.customer.entity;

import com.doomsaj.bank_project_spring.domain.embeddeds.DateProperties;
import com.doomsaj.bank_project_spring.domain.account.entity.Account;
import com.doomsaj.bank_project_spring.utils.SecurityUtils;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.KeyPair;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long number;

    private String password;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;

    @Embedded
    private DateProperties dates;

    public Customer(long number, DateProperties dates, String password) {
        this.number = number;
        this.dates = dates;
        KeyPair pair = SecurityUtils.RSA.getPair();
        this.password = SecurityUtils.RSA.encrypt(password, pair.getPublic());
    }
}
