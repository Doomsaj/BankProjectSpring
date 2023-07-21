package com.doomsaj.bank_project_spring.domain.branch.entity;

import com.doomsaj.bank_project_spring.domain.account.entity.AccountDTO;
import com.doomsaj.bank_project_spring.domain.bank.entity.BankDTO;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {
    long id;
    String name;
    BankDTO bank;
    Set<AccountDTO> accounts;
    DatePropertiesDTO dates;
}
