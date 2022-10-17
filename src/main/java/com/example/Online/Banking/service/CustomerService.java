package com.example.Online.Banking.service;

import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.repo.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class CustomerService {
    private final BankAccountRepo bankAccountRepo;
    @Autowired
    public CustomerService(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }

    public BankAccount addBankAccount(BankAccount bankAccount){
        Random random = new Random(5);
        bankAccount.setAccountNumber("AL" + bankAccount.getId() + "00000" + random.toString());
        return bankAccountRepo.save(bankAccount);
    }

    public List<BankAccount> showAllBankAccounts(Integer id){
        return bankAccountRepo.findAllBankAccountsById(id);
    }
}
