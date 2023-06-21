package com.pustovit.springpractice.controller.mapper;

import com.pustovit.springpractice.controller.dto.UserDto;
import com.pustovit.springpractice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getPhone(),
                user.getEmail()
        );
    }

    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAge(),
                userDto.getPhone(),
                userDto.getEmail()
        );
    }
}
