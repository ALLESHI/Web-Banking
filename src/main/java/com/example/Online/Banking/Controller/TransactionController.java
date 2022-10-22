package com.example.Online.Banking.Controller;

import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.model.Transaction;
import com.example.Online.Banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("deposit")
    public ResponseEntity<Void> deposit(@RequestBody BankAccount bankAccount, Double amount) throws Exception {
        transactionService.depositTransaction(bankAccount, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("withdraw")
    public ResponseEntity<Void> withdraw(@RequestBody Transaction transaction, BankAccount bankAccount, Double amount) throws Exception {
        transactionService.withdrawTransaction(transaction, bankAccount, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("transfer")
    public ResponseEntity<Void> transfer(@RequestBody BankAccount bankAccount, Double amount) throws Exception {
        transactionService.accountTransferTransaction(amount, bankAccount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}