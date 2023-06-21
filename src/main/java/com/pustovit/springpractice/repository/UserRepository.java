package com.pustovit.springpractice.repository;

import com.pustovit.springpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    //    Query with a few params
    User getUserByPhoneAndEmail(String phone, String email);

//    Custom query
    @Transactional
    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    Integer update(String name, Integer id);


}
