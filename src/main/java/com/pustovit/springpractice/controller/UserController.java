package com.pustovit.springpractice.controller;

import com.pustovit.springpractice.controller.dto.IntegerDto;
import com.pustovit.springpractice.controller.dto.UserDto;
import com.pustovit.springpractice.controller.mapper.UserMapper;
import com.pustovit.springpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(final UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

//        @RequestMapping(path = "/all",method = RequestMethod.GET)


//    @GetMapping
//    public List<UserDto> getAll() {
//        return userService.getAll().stream()
//                .map(userMapper::toDto)
//                .collect(Collectors.toList());
//    }
//


    //        Using Response Entity to create custom responses, not only "OK"
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(
                userService.getAll().stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList()),
                HttpStatus.ACCEPTED
        );
    }

    //    Request with custom body
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userMapper.toDto(userService.getById(id)));
    }


    @GetMapping("/{phone}/{email}")
    public UserDto getByPhoneAndEmail(
            @PathVariable String phone,
            @PathVariable String email
    ) {
        return userMapper.toDto(userService.getByPhoneAndEmail(phone, email));
    }

    @GetMapping("/filter")
    public UserDto getUserByFilter(
            @RequestParam() String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Integer age) {

        return userMapper.toDto(userService.getUserByFilter(name, surname, age));
    }

    // Response entity CREATED for save(POST)
    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
//        Can add some validation
        if (userDto.getName() == null || userDto.getName().isBlank()) {
            return ResponseEntity.badRequest().body(null);
        }
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.save(
                                userMapper.toEntity(userDto))),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        return userMapper.toDto
                (userService.update(userMapper.toEntity(userDto)));
    }

    @PutMapping("/{id}/{name}")
    public IntegerDto updateNameById(
            @PathVariable Integer id,
            @PathVariable String name
    ) {
        return new IntegerDto(userService.updateNameById(name, id));
    }



    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
}


