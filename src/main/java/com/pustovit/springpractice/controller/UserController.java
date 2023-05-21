package com.pustovit.springpractice.controller;

import com.pustovit.springpractice.entity.User;
import com.pustovit.springpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAll() {
        return userService.getAll();
    }

}
