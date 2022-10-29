package com.example.Online.Banking.Controller;

import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.model.Transaction;
import com.example.Online.Banking.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("deposit/{amount}")
    public ResponseEntity<Void> deposit(BankAccount bankAccount, @PathVariable("amount") Double amount) throws Exception {
        transactionService.depositTransaction(bankAccount, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("withdraw/{amount}")
    public ResponseEntity<Void> withdraw(Transaction transaction, BankAccount bankAccount, @PathVariable("amount") Double amount) throws Exception {
        transactionService.withdrawTransaction(transaction, bankAccount, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("transfer")
//    public ResponseEntity<Void> transfer(@RequestBody BankAccount bankAccount, Double amount) throws Exception {
//        transactionService.accountTransferTransaction(amount, bankAccount);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}