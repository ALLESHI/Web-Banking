package com.example.Online.Banking.model;

import java.sql.Timestamp;

public class Transaction {
    private Integer id;
    private BankAccount bankAccount;
    private long transactionAmount;
    private Timestamp transactionDateTime;

}
