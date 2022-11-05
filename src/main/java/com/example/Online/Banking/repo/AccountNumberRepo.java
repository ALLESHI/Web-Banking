package com.example.Online.Banking.repo;

import com.example.Online.Banking.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountNumberRepo extends JpaRepository<BankAccount, Long> {

//    List<BankAccount> findAllById(Long id);
//
//    boolean findBankAccountsByAccountNumber(String accountNumber);
}
