package com.example.Online.Banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userID;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany
    @JoinColumn(name = "account_id")
    @PrimaryKeyJoinColumn
    private List<BankAccount> bankAccountList;

}
