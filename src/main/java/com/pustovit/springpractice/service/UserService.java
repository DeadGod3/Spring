package com.pustovit.springpractice.service;

import com.pustovit.springpractice.entity.User;
import com.pustovit.springpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public User getByPhoneAndEmail(String phone, String email) {
        return userRepository.getByPhoneAndEmail(phone, email);
    }

    public User getUserByFilter(String name, String surname, Integer age) {
        return userRepository.getUserByFilter(name, surname, age);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        return userRepository.update(id, user);
    }

    public Integer delete(Integer id) {
        return userRepository.delete(id);
    }
}
