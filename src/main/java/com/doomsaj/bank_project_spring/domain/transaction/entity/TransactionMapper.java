package com.doomsaj.bank_project_spring.domain.transaction.entity;

import com.doomsaj.bank_project_spring.domain.account.entity.AccountMapper;
import com.doomsaj.bank_project_spring.domain.embeddeds.date_props.DatePropertiesMapper;

public class TransactionMapper {
    public static TransactionDTO entityToDto(Transaction entity) {
        return new TransactionDTO(
                entity.getId(),
                entity.getAmount(),
                entity.getType(),
                AccountMapper.entityToDto(entity.getAccount()),
                entity.isStatus(),
                entity.getDescription(),
                DatePropertiesMapper.entityToDto(entity.getDates())
        );
    }

    public static Transaction dtoToEntity(TransactionDTO dto) {
        return new Transaction(
                dto.getAmount(),
                dto.getType(),
                AccountMapper.dtoToEntity(dto.getAccount()),
                DatePropertiesMapper.dtoToEntity(dto.getDates())
        );
    }
}
