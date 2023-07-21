package com.doomsaj.bank_project_spring.domain.bank.service;

import com.doomsaj.bank_project_spring.domain.bank.entity.Bank;
import com.doomsaj.bank_project_spring.domain.bank.entity.BankDTO;
import com.doomsaj.bank_project_spring.domain.bank.entity.BankMapper;
import com.doomsaj.bank_project_spring.domain.bank.exception.BankNotFound;
import com.doomsaj.bank_project_spring.domain.bank.repository.BankRepository;
import com.doomsaj.bank_project_spring.domain.branch.entity.Branch;
import com.doomsaj.bank_project_spring.domain.branch.entity.BranchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BankServiceImlp implements BankService {
    private BankRepository repository;

    @Autowired
    public BankServiceImlp(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankDTO createBank(BankDTO bank) {
        Bank savedBank = repository.save(BankMapper.dtoToEntity(bank));
        return BankMapper.entityToDto(savedBank);
    }

    @Override
    public BankDTO getBankById(Long bankId) {
        BankDTO bank = null;
        try { //todo add logger message and remove try, add exception to method signature
            bank = BankMapper.entityToDto(repository.findById(bankId).orElseThrow(BankNotFound::new));
        } catch (BankNotFound e) {
            System.out.println(e.getMessage());
        }
        return bank;
    }

    @Override
    public List<BankDTO> getAllBanks() {
        List<Bank> banks = repository.findAll();
        return banks.stream().map(BankMapper::entityToDto).toList();
    }

    @Override
    public BankDTO updateBank(Long bankId, BankDTO bank) {
        BankDTO updateDto = null;
        try { //todo add logger message and remove try, add exception to method signature
            Bank existedBank = repository.findById(bankId).orElseThrow(BankNotFound::new);


            existedBank.setName(bank.getName());
            existedBank.getDates().setUpdated_at(LocalDate.now());

            if (bank.getBranches().size() > 0) {
                Set<Branch> updatedBranches = bank.getBranches().stream().map(BranchMapper::dtoToEntity).collect(Collectors.toSet());
                existedBank.setBranches(updatedBranches);
            }

            updateDto = BankMapper.entityToDto(repository.save(existedBank));
        } catch (BankNotFound e) {
            System.out.println(e.getMessage());
        }
        return updateDto;
    }

    @Override
    public void deleteBank(Long bankId) {
        repository.deleteById(bankId);
    }

    @Override
    public boolean existsById(Long bankId) {
        return repository.existsById(bankId);
    }
}
