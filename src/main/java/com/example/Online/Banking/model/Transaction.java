package com.example.Online.Banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private Integer id;
    private long transactionAmount;
    private LocalDateTime localDateTime;

    @OneToOne
    @JoinColumn(name = "account_id")
    private BankAccount bankAccountList;
}
