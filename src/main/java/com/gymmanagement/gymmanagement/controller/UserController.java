package com.gymmanagement.gymmanagement.controller;

import com.gymmanagement.gymmanagement.entity.Member;
import com.gymmanagement.gymmanagement.entity.User;
import com.gymmanagement.gymmanagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        return userService.loginUser(user.getEmailId(),user.getPassword());
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody Member member,@RequestParam String password){
        User user = new User();
        user.setEmailId(member.getEmail());
        user.setPassword(password);
        return userService.registerUser(user,member);
    }

}
