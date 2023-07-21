package com.doomsaj.bank_project_spring.domain.account.entity;

import com.doomsaj.bank_project_spring.domain.branch.entity.BranchMapper;
import com.doomsaj.bank_project_spring.domain.customer.entity.CustomerDTO;
import com.doomsaj.bank_project_spring.domain.customer.entity.CustomerMapper;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesMapper;
import com.doomsaj.bank_project_spring.domain.transaction.entity.TransactionMapper;

import java.util.stream.Collectors;

public class AccountMapper {
    public static AccountDTO entityToDto(Account entity) {
        return new AccountDTO(
                entity.getId(),
                entity.getNumber(),
                BranchMapper.entityToDto(entity.getBranch()),
                entity.getBalance(),
                CustomerMapper.entityToDto(entity.getCustomer()),
                entity.getTransactions().stream().map(TransactionMapper::entityToDto).collect(Collectors.toSet()),
                DatePropertiesMapper.entityToDto(entity.getDates())
        );
    }

    public static Account dtoToEntity(AccountDTO dto) {
        return new Account(
                dto.getNumber(),
                BranchMapper.dtoToEntity(dto.getBranch()),
                CustomerMapper.dtoToEntity(dto.getCustomer()),
                DatePropertiesMapper.dtoToEntity(dto.getDates())
        );
    }
}
