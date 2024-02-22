package com.example.hexagonal.appcore.port;

import com.example.hexagonal.appcore.model.UserMdl;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    UserMdl saveUser(UserMdl userMdl);
    List<UserMdl> getUsers();
    Optional<UserMdl> getUserById(Integer id);
}
