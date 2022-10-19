package com.example.Online.Banking.service;

import com.example.Online.Banking.model.AccountNumber;
import com.example.Online.Banking.repo.AccountNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class AccountNumberService {
    private final AccountNumberRepo accountNumberRepo;
    @Autowired
    public AccountNumberService(AccountNumberRepo accountNumberRepo) {
        this.accountNumberRepo = accountNumberRepo;
    }

    public AccountNumber addBankAccount(AccountNumber accountNumber){
        Random random = new Random(5);
        accountNumber.setAccountNumber("AL" + accountNumber.getId() + "00000" + random.toString());
        return accountNumberRepo.save(accountNumber);
    }

    public List<AccountNumber> showAllBankAccounts(Integer id){
        return accountNumberRepo.findAllBankAccountsById(id);
    }
}
