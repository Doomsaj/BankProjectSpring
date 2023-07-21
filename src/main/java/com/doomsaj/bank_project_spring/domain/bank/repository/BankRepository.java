package com.doomsaj.bank_project_spring.domain.bank.repository;

import com.doomsaj.bank_project_spring.domain.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}