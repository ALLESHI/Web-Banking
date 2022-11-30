package com.example.Online.Banking.Controller;
import com.example.Online.Banking.dto.UserDTO;
import com.example.Online.Banking.model.User;
import com.example.Online.Banking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.addUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO user){
        String loginUser = userService.loginUser(user);
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }
    @GetMapping("/showAllUsers")
    public ResponseEntity<List<User>> showAllUsers(){
        List<User> userList = userService.showUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @GetMapping("/Users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
