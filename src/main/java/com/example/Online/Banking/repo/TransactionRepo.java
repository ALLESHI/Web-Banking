package com.example.Online.Banking.repo;

import com.example.Online.Banking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
}
