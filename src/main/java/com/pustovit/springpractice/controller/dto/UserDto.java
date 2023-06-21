package com.pustovit.springpractice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;
    public String name;
    public String surname;
    public Integer age;
    public String phone;
    public String email;

}
