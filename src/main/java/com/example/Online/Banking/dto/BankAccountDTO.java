package com.example.Online.Banking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountDTO {
    private Long id;
    private String accountNumber;
    private String bankAccountType;
    private String bankAccountCurrency;
    private double balance;
    private Integer userId;
}