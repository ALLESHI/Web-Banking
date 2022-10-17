package com.example.Online.Banking.repo;

import com.example.Online.Banking.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {

    List<BankAccount> findAllBankAccountsById(Integer id);
}
