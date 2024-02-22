package com.example.hexagonal.adapter.primary.controller;

import com.example.hexagonal.appcore.model.UserMdl;
import com.example.hexagonal.appcore.service.UserService;
import com.example.hexagonal.mapper.UserMapper;
import com.example.hexagonal.adapter.primary.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto){
        UserMdl userMdl = UserMapper.INSTANCE.userDtoToUserMdl(userDto);
        UserMdl savedUserMdl = userService.saveUser(userMdl);
        return UserMapper.INSTANCE.userMdlToUserDto(savedUserMdl);
    }

    @GetMapping
    public List<UserDto> getUsers(){
        List<UserMdl> userMdls = userService.getUsers();
        return UserMapper.INSTANCE.userMdlListToUserDtoList(userMdls);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        Optional<UserMdl> userMdl = userService.getUserById(id);

        if (userMdl.isPresent()) {
            UserDto userDto = UserMapper.INSTANCE.userMdlToUserDto(userMdl.get());
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
