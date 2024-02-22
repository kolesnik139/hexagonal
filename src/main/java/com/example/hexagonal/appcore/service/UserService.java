package com.example.hexagonal.appcore.service;

import com.example.hexagonal.appcore.model.UserMdl;
import com.example.hexagonal.appcore.port.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public UserMdl saveUser(UserMdl userMdl){
        return userRepository.saveUser(userMdl);
    }

    public List<UserMdl> getUsers(){
        return userRepository.getUsers();
    }

    public Optional<UserMdl> getUserById(Integer id){
        return userRepository.getUserById(id);
    }
}
