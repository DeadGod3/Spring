package com.pustovit.springpractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    public String name;
    public String surname;
    public Integer age;
    public String phone;
    public String email;
}
