package com.example.Online.Banking.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String accountNumber;
    private BankAccountType bankAccountType;
    private BankAccountCurrency bankAccountCurrency;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
}
