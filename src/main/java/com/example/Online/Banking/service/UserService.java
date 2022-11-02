package com.example.Online.Banking.service;

import com.example.Online.Banking.dto.UserDTO;
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

    public User getUserById(Integer id){
        return userRepo.findById(id).get();
    }

    public void deleteUserById(Integer id){
        userRepo.deleteById(id);
    }

    public List<User> showUsers(){
        return userRepo.findAll();
    }

    public UserDTO entityToDTO(User entity){
        UserDTO userDTO = new UserDTO();

        userDTO.setName(entity.getName());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPhone(entity.getPhone());
        userDTO.setPassword(entity.getPassword());
        userDTO.setBankAccountId(entity.getBankAccounts().listIterator().next().getBankAccountID());
        return userDTO;
    }
}
