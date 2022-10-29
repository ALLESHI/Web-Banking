package com.example.Online.Banking.Controller;

import com.example.Online.Banking.dto.BankAccountDTO;
import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.model.User;
import com.example.Online.Banking.service.BankAccountService;
import com.example.Online.Banking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountNumber")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    private final UserService userService;

    public BankAccountController(BankAccountService bankAccountService, UserService userService) {
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }


    @PostMapping("/createAccount")
    public ResponseEntity<BankAccount> createBankAccounts(@RequestBody BankAccountDTO bankAccount){
        BankAccount newBankAccount = bankAccountService.dtotoEntity(bankAccount);
        bankAccountService.addBankAccount(newBankAccount);
        return new ResponseEntity<>(newBankAccount, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BankAccount> findById(@PathVariable("id") Long id){
        BankAccount bankAccount = bankAccountService.findById(id);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

//    @GetMapping("/findAllById/{id}")
//    public ResponseEntity<List<BankAccount>> showAllBankAccountsById(@PathVariable("id") Long id){
//        List<BankAccount> bankAccountList = List.of();
//        return new ResponseEntity<>(bankAccountList, HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable("id") Long id){
        bankAccountService.deleteBankAccountById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}