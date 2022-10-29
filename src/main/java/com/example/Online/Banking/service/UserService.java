package com.example.Online.Banking.service;

import com.example.Online.Banking.model.User;
import com.example.Online.Banking.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User getUser(Integer id){
        return userRepo.findById(id).get();
    }

    public void deleteUserById(Integer id){
        userRepo.deleteById(id);
    }

    public List<User> showUsers(){
        return userRepo.findAll();
    }
}
