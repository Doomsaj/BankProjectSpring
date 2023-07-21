package com.doomsaj.bank_project_spring.domain.transaction.entity;

import com.doomsaj.bank_project_spring.domain.account.entity.AccountDTO;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesDTO;
import com.doomsaj.bank_project_spring.domain.transaction.consts.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    long id;
    double amount;
    TransactionType type;
    AccountDTO account;
    boolean status;
    String description;
    DatePropertiesDTO dates;
}
