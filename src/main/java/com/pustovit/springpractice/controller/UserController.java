package com.pustovit.springpractice.controller;

import com.pustovit.springpractice.entity.User;
import com.pustovit.springpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    @RequestMapping(path = "/all",method = RequestMethod.GET)
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }


    @GetMapping("/{phone}/{email}")
    public User getByPhoneAndEmail(
            @PathVariable String phone,
            @PathVariable String email
    ) {
        return userService.getByPhoneAndEmail(phone, email);
    }

    @GetMapping("/filter")
    public User getUserByFilter(
            @RequestParam() String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Integer age) {

        return userService.getUserByFilter(name, surname, age);
    }

    @PostMapping
    public User save (@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id,@RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping
    public Integer delete(@RequestParam Integer id){
        return userService.delete(id);
    }
}


