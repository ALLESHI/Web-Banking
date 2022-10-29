package com.example.Online.Banking.service;
import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.model.Transaction;
import com.example.Online.Banking.repo.AccountNumberRepo;
import com.example.Online.Banking.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TransactionService {
    private final AccountNumberRepo accountNumberRepo;
    private final TransactionRepo transactionRepo;
    BankAccount bankAccount;
    Transaction transaction;

    public TransactionService(AccountNumberRepo accountNumberRepo, TransactionRepo transactionRepo) {
        this.accountNumberRepo = accountNumberRepo;
        this.transactionRepo = transactionRepo;
    }


    public Transaction depositTransaction(BankAccount bankAccount, Double amount) throws Exception {
        if (amount > 0){
            bankAccount.setBalance(bankAccount.getBalance() + amount);
        } else{
            throw new Exception("Unsuccessful transaction! Amount can not be zero or negative number");
        } return transactionRepo.save(transaction);
    }

    public Transaction withdrawTransaction (Transaction transaction, BankAccount bankAccount, Double amount) throws Exception {
        if (amount <= bankAccount.getBalance()){
            bankAccount.setBalance(bankAccount.getBalance() - amount);
        }else{
            throw new Exception("Unsuccessful transaction! You don't have enough balance!");
        } return transactionRepo.save(transaction);
    }
//    public Transaction accountTransferTransaction(Double amount, BankAccount bankAccount) throws Exception {
//        if (this.accountNumberRepo.findBankAccountsByAccountNumber(bankAccount.getAccountNumber())){
//            if (this.bankAccount.getBalance() >= amount) {
//                this.bankAccount.setBalance(this.bankAccount.getBalance() - amount);
//                bankAccount.setBalance(bankAccount.getBalance() + amount);
//            }else{
//                throw new Exception("Unsuccessful transaction! You don't have enough balance!");
//            }
//        } return transactionRepo.save(transaction);
//    }
}
