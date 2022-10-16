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
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String accountNumber;
    private String type;
    private String currency;
    private long balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;
}
