package com.example.Online.Banking.repo;

import com.example.Online.Banking.model.AccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountNumberRepo extends JpaRepository<AccountNumber, Integer> {

    List<AccountNumber> findAllBankAccountsById(Integer id);

    boolean findBankAccountsByAccountNumber(String accountNumber);
}
