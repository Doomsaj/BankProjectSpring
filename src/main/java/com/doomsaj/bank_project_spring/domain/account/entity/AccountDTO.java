package com.doomsaj.bank_project_spring.domain.account.entity;

import com.doomsaj.bank_project_spring.domain.branch.entity.BranchDTO;
import com.doomsaj.bank_project_spring.domain.customer.entity.CustomerDTO;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesDTO;
import com.doomsaj.bank_project_spring.domain.transaction.entity.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    long id;
    long number;
    Long branchId;
    long balance;
    Long customerId;
    Set<Long> transactionsIds;
    DatePropertiesDTO dates;
}
