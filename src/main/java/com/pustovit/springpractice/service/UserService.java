package com.pustovit.springpractice.service;

import com.pustovit.springpractice.entity.User;
import com.pustovit.springpractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

//    private final FakeUserRepository fakeUserRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
//        return userRepository.getById(id);
    }
    public Optional<User> getOptionalById(Integer id){
        return userRepository.findById(id);
    }

//    Query with a few parameters from JpaRepository
    public User getByPhoneAndEmail(String phone, String email) {
        return userRepository.getUserByPhoneAndEmail(phone, email);
    }

    public User getUserByFilter(String name, String surname, Integer age) {
        return null;
//        return userRepository.getUserByFilter(name, surname, age);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

//    To Put(Update User's params need to put his id in Json body
    public User update(User user) {
        return userRepository.save(user);
    }

    public Integer updateNameById(String name, Integer id) {
        return userRepository.update(name, id);
    }


    public Integer delete(Integer id) {
         userRepository.deleteById(id);
         return id;
    }
}
