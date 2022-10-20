package com.example.Online.Banking.repo;

import com.example.Online.Banking.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountNumberRepo extends JpaRepository<BankAccount, Integer> {

    List<BankAccount> findAllBankAccountsById(Integer id);

    boolean findBankAccountsByAccountNumber(String accountNumber);
}
