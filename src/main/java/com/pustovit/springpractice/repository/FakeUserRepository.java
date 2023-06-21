package com.pustovit.springpractice.repository;

import com.pustovit.springpractice.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeUserRepository {
    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User(0, "Ihor", "Pustovit", 20, "385532521", "3flowerofsun3@gmail.com"));
        users.add(new User(1, "IO", "Pustovit", 201, "380231134", "io@gmail.com"));
        users.add(new User(2, "Aleks", "Shevchenko", 30, "302311235", "aleks@mail.u"));
    }

//    private final List<User> users = List.of(
//            new User(0, "Ihor", "Pustovit", 20, "385532521", "3flowerofsun3@gmail.com"),
//            new User(1, "IO", "Pustovit", 201, "380231134", "io@gmail.com"),
//            new User(2, "Aleks", "Shevchenko", 30, "302311235", "aleks@mail.u")
//    );


    public List<User> getAll() {
        return users;
    }

    public User getById(Integer id) {
        return users.get(id);
    }

    //    Validation for Spring(Rest-API) in stream
    public User getByPhoneAndEmail(String phone, String email) {
        //получаем первый подходящий объект
        //или null, если таких нет
        User temp = users.stream()
                .filter(a -> phone.equals(a.getPhone()))
                .filter(b -> email.equals(b.getEmail()))
                .findFirst()
                .orElse(null);
        return temp;
    }

    public User getUserByFilter(String name, String surname, Integer age) {
        return users.stream()
                .filter(a -> name.equals(a.getName()))
                .filter(b -> surname.equals(b.getSurname()))
                .filter(c -> age.equals(c.getAge()))
                .findFirst()
                .orElse(null);
    }

    public User save(User user) {
        users.add(user);
        user.setId(users.size());
        return user;
    }

    public User update(Integer id, User user) {
        User oldUser = users.get(id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setAge(user.getAge());
        oldUser.setPhone(user.getPhone());
        oldUser.setEmail(user.getEmail());

        return users.get(id);

    }

    public Integer delete(int id) {
        users.remove(id);
        return id;
    }
}
