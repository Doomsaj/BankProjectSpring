package com.doomsaj.bank_project_spring.domain.branch.entity;

import com.doomsaj.bank_project_spring.domain.account.entity.AccountMapper;
import com.doomsaj.bank_project_spring.domain.bank.entity.BankMapper;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesMapper;

import java.util.stream.Collectors;

public class BranchMapper {
    public static BranchDTO entityToDto(Branch entity) {
        return new BranchDTO(
                entity.getId(),
                entity.getName(),
                BankMapper.entityToDto(entity.getBank()),
                entity.getAccounts().stream().map(AccountMapper::entityToDto).collect(Collectors.toSet()),
                DatePropertiesMapper.entityToDto(entity.getDates())
        );
    }

    public static Branch dtoToEntity(BranchDTO dto) {
        return new Branch(
                dto.getName(),
                BankMapper.dtoToEntity(dto.getBank()),
                DatePropertiesMapper.dtoToEntity(dto.getDates())
        );
    }
}
