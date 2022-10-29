package com.example.Online.Banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false, unique = true, updatable = false)
    private Long bankAccountID;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private BankAccountType bankAccountType;

    @Enumerated(EnumType.STRING)
    private BankAccountCurrency bankAccountCurrency;

    private double balance;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}