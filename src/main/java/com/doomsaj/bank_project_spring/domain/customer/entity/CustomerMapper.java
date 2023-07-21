package com.doomsaj.bank_project_spring.domain.customer.entity;

import com.doomsaj.bank_project_spring.domain.account.entity.AccountMapper;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesMapper;

import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerDTO entityToDto(Customer entity) {
        return new CustomerDTO(
                entity.getId(),
                entity.getNumber(),
                entity.getAccounts().stream().map(AccountMapper::entityToDto).collect(Collectors.toSet()),
                entity.getPassword(),
                DatePropertiesMapper.entityToDto(entity.getDates())
        );
    }

    public static Customer dtoToEntity(CustomerDTO dto) {
        return new Customer(
                dto.getNumber(),
                DatePropertiesMapper.dtoToEntity(dto.getDates()),
                dto.getPassword()
        );
    }
}
