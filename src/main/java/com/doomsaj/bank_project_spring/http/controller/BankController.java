package com.doomsaj.bank_project_spring.http.controller;

import com.doomsaj.bank_project_spring.domain.bank.entity.BankDTO;
import com.doomsaj.bank_project_spring.domain.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    private BankService service;

    @Autowired
    public BankController(BankService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BankDTO> store(@RequestBody BankDTO bank) {
        return new ResponseEntity<>(service.createBank(bank), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BankDTO>> index() {
        return new ResponseEntity<>(service.getAllBanks(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BankDTO> update(@PathVariable Long id, @RequestBody BankDTO bank) {
        if (!service.existsById(id)) {
            System.out.println("bank not found");
            return null;
        }

        return new ResponseEntity<>(service.updateBank(id, bank), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDTO> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.getBankById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        service.deleteBank(id);
    }
}
