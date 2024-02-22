package com.example.hexagonal.adapter.secondary.repository;

import com.example.hexagonal.adapter.secondary.entity.User;
import com.example.hexagonal.appcore.model.UserMdl;
import com.example.hexagonal.appcore.port.IUserRepository;
import com.example.hexagonal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository{
    @Autowired
    UserJPARepository userRepository;

    @Override
    public UserMdl saveUser(UserMdl userMdl) {
        User user = UserMapper.INSTANCE.userMdlToUser(userMdl);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserMdl(savedUser);
    }

    @Override
    public List<UserMdl> getUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.userListToUserMdlList(users);
    }

    @Override
    public Optional<UserMdl> getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.INSTANCE.optionalUserToOptionalUserMdl(user);
    }
}
