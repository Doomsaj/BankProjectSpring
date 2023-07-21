package com.doomsaj.bank_project_spring.domain.bank.exception;

public class BankNotFound extends Exception{
    public BankNotFound() {
        this("بانک مورد نظر یافت نشد.");
    }

    public BankNotFound(String message) {
        super(message);
    }
}
