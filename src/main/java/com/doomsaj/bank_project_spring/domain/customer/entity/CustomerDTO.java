package com.doomsaj.bank_project_spring.domain.customer.entity;

import com.doomsaj.bank_project_spring.domain.account.entity.AccountDTO;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    long id;
    long number;
    Set<AccountDTO> accounts;
    String password;
    DatePropertiesDTO dates;
}
