package com.example.Online.Banking.service;

import com.example.Online.Banking.model.AccountNumber;
import com.example.Online.Banking.repo.AccountNumberRepo;
import com.example.Online.Banking.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionService {
    private final TransactionRepo transactionRepo;
    private final AccountNumberRepo accountNumberRepo;
    private final AccountNumber accountNumber;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo, AccountNumber accountNumber, AccountNumberRepo accountNumberRepo) {
        this.transactionRepo = transactionRepo;
        this.accountNumberRepo = accountNumberRepo;
        this.accountNumber = accountNumber;
    }


    public static void deposit(AccountNumber accountNumber, Double amount) throws Exception {
        if (amount > 0){
            accountNumber.setBalance(accountNumber.getBalance() + amount);
        } else{
            throw new Exception("Unsuccessful transaction! Amount can not be a negative number");
        }
    }

    public static void withdraw(AccountNumber accountNumber, Double amount) throws Exception {
        if (amount >= accountNumber.getBalance()){
            accountNumber.setBalance(amount - accountNumber.getBalance());
        }else{
            throw new Exception("Unsuccessful transaction! You don't have enough balance!");
        }
    }
    public void accountTransfer(Double amount, AccountNumber accountNumber) throws Exception {
        if (this.accountNumberRepo.findBankAccountsByAccountNumber(accountNumber.getAccountNumber())){
            if (this.accountNumber.getBalance() >= amount) {
                this.accountNumber.setBalance(this.accountNumber.getBalance() - amount);
                accountNumber.setBalance(accountNumber.getBalance() + amount);
            }else{
                throw new Exception("Unsuccessful transaction! You don't have enough balance!");
            }
        }
    }
}
