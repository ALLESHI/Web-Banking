package com.example.Online.Banking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer userID;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private Long bankAccountId;
}
