package com.example.Online.Banking.service;

import com.example.Online.Banking.dto.BankAccountDTO;
import com.example.Online.Banking.model.BankAccount;
import com.example.Online.Banking.model.BankAccountCurrency;
import com.example.Online.Banking.model.BankAccountType;
import com.example.Online.Banking.model.User;
import com.example.Online.Banking.repo.AccountNumberRepo;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    private final AccountNumberRepo accountNumberRepo;
    private final UserService userService;

    public BankAccountService(AccountNumberRepo accountNumberRepo, UserService userService) {
        this.accountNumberRepo = accountNumberRepo;
        this.userService = userService;
    }

    public BankAccount addBankAccount(BankAccount bankAccount){
        return accountNumberRepo.save(bankAccount);
    }

    public BankAccount findById(Long id){
        return accountNumberRepo.findById(id).get();
    }

//    public List<BankAccount> showAllBankAccounts(Long id){
//        List<T> results = new ArrayList<T>();
//
//        for (ID id : ids) {
//            findById(id).ifPresent(results::add);
//        }
//        return accountNumberRepo.findAllById(bankAccountList);
//    }

    public void deleteBankAccountById(Long id){
        accountNumberRepo.deleteById(id);
    }


    public BankAccountDTO entityToDTO(BankAccount entity){
        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO.setAccountNumber(entity.getAccountNumber());
        bankAccountDTO.setBankAccountCurrency(entity.getBankAccountCurrency().toString());
        bankAccountDTO.setBalance(entity.getBalance());
        bankAccountDTO.setUserId(entity.getUser().getUserID());
        return bankAccountDTO;
    }

    public BankAccount DTOToEntity(BankAccountDTO bankAccountDTO){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankAccountID(bankAccountDTO.getId());
        bankAccount.setBankAccountCurrency(BankAccountCurrency.valueOf(bankAccountDTO.getBankAccountCurrency()));
        bankAccount.setBalance(bankAccountDTO.getBalance());
        bankAccount.setBankAccountType(BankAccountType.valueOf(bankAccountDTO.getBankAccountType()));
        bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
        User user = userService.getUser(bankAccountDTO.getUserId());
        bankAccount.setUser(user);

        return bankAccount;
    }
}
