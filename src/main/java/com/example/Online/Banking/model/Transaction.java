package com.example.Online.Banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private Long id;
    private Double transactionAmount;
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private BankAccount bankAccounts;
}