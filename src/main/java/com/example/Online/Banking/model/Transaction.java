package com.example.Online.Banking.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private AccountNumber accountNumber;
    private long transactionAmount;
    private Timestamp transactionDateTime;

}
