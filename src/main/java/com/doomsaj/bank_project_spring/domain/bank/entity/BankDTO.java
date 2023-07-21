package com.doomsaj.bank_project_spring.domain.bank.entity;

import com.doomsaj.bank_project_spring.domain.branch.entity.Branch;
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
public class BankDTO {
    long id;
    String name;
    Set<Branch> branches;
    DatePropertiesDTO dateProperties;
}
