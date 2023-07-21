package com.doomsaj.bank_project_spring.domain.bank.entity;

import com.doomsaj.bank_project_spring.domain.embeddeds.DateProperties;
import com.doomsaj.bank_project_spring.domain.branch.entity.Branch;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
    private Set<Branch> branches = new HashSet<>();

    @Embedded
    private DateProperties dates;

    public Bank(String name, DateProperties dates) {
        this.name = name;
        this.dates = dates;
    }
}

