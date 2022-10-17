package com.example.Online.Banking.repo;

import com.example.Online.Banking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
