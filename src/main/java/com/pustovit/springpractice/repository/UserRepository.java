package com.pustovit.springpractice.repository;

import com.pustovit.springpractice.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public List<User> getAll() {
        return List.of(
                new User("Ihor", "Pustovit", 20),
                new User("IO", "Pustovit", 201)
        );
    }
}
