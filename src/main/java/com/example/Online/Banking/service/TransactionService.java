package com.example.Online.Banking.service;

import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.repo.AccountNumberRepo;
import com.example.Online.Banking.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final AccountNumberRepo accountNumberRepo;
    BankAccount bankAccount;

    @Autowired
    public TransactionService(AccountNumberRepo accountNumberRepo) {
        this.accountNumberRepo = accountNumberRepo;
    }


    public void deposit(BankAccount bankAccount, Double amount) throws Exception {
        if (amount > 0){
            bankAccount.setBalance(bankAccount.getBalance() + amount);
        } else{
            throw new Exception("Unsuccessful transaction! Amount can not be zero or negative number");
        }
    }

    public void withdraw(BankAccount bankAccount, Double amount) throws Exception {
        if (amount <= bankAccount.getBalance()){
            bankAccount.setBalance(bankAccount.getBalance() - amount);
        }else{
            throw new Exception("Unsuccessful transaction! You don't have enough balance!");
        }
    }
    public void accountTransfer(Double amount, BankAccount bankAccount) throws Exception {
        if (this.accountNumberRepo.findBankAccountsByAccountNumber(bankAccount.getAccountNumber())){
            if (this.bankAccount.getBalance() >= amount) {
                this.bankAccount.setBalance(this.bankAccount.getBalance() - amount);
                bankAccount.setBalance(bankAccount.getBalance() + amount);
            }else{
                throw new Exception("Unsuccessful transaction! You don't have enough balance!");
            }
        }
    }
}
