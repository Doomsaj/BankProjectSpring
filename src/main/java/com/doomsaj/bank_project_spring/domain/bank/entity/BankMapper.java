package com.doomsaj.bank_project_spring.domain.bank.entity;

import com.doomsaj.bank_project_spring.domain.branch.entity.BranchMapper;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesMapper;

import java.util.stream.Collectors;

public class BankMapper {
    public static BankDTO entityToDto(Bank entity) {
        return new BankDTO(
                entity.getId(),
                entity.getName(),
                entity.getBranches().stream().map(BranchMapper::entityToDto).collect(Collectors.toSet()),
                DatePropertiesMapper.entityToDto(entity.getDates())
        );
    }

    public static Bank dtoToEntity(BankDTO dto) {
        return new Bank(
                dto.getName(),
                DatePropertiesMapper.dtoToEntity(dto.getDateProperties())
        );
    }
}
