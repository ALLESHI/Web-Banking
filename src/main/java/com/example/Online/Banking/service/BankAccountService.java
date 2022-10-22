package com.example.Online.Banking.service;

import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.repo.AccountNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class BankAccountService {
    private final AccountNumberRepo accountNumberRepo;
    @Autowired
    public BankAccountService(AccountNumberRepo accountNumberRepo) {
        this.accountNumberRepo = accountNumberRepo;
    }

    public BankAccount addBankAccount(BankAccount bankAccount){
//        Random random = new Random(5);
//        bankAccount.setAccountNumber("AL" + bankAccount.getId().toString() + "00000");
        return accountNumberRepo.save(bankAccount);
    }

    public List<BankAccount> showAllBankAccounts(Integer id){
        return accountNumberRepo.findAllBankAccountsById(id);
    }
}
