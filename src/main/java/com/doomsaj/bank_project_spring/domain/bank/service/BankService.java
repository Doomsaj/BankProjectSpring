package com.doomsaj.bank_project_spring.domain.bank.service;

import com.doomsaj.bank_project_spring.domain.bank.entity.BankDTO;

import java.util.List;

public interface BankService {
    BankDTO createBank(BankDTO bank);
    BankDTO getBankById(Long bankId);
    List<BankDTO> getAllBanks();
    BankDTO updateBank(Long bankId, BankDTO bank);
    void deleteBank(Long bankId);
    boolean existsById(Long bankId);
}
