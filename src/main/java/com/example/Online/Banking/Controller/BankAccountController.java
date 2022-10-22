package com.example.Online.Banking.Controller;

import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountNumber")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/createAccount")
    public ResponseEntity<BankAccount> createBankAccounts(@RequestBody BankAccount bankAccount){
        BankAccount newBankAccount = bankAccountService.addBankAccount(bankAccount);
        return new ResponseEntity<>(newBankAccount, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<List<BankAccount>> showAllBankAccounts(@PathVariable("id") Integer id){
        List<BankAccount> bankAccountList = bankAccountService.showAllBankAccounts(id);
        return new ResponseEntity<>(bankAccountList, HttpStatus.OK);
    }
}