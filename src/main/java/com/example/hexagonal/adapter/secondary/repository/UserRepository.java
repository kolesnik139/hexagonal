package com.example.hexagonal.adapter.secondary.repository;

import com.example.hexagonal.adapter.secondary.entity.UserEnt;
import com.example.hexagonal.appcore.model.UserMdl;
import com.example.hexagonal.appcore.port.IUserRepository;
import com.example.hexagonal.adapter.secondary.mapper.UserEntMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository{
    @Autowired
    UserJPARepository userRepository;

    @Autowired
    UserEntMapper userEntMapper;

    @Override
    public UserMdl saveUser(UserMdl userMdl) {
        UserEnt userEnt = userEntMapper.userMdlToUser(userMdl);
        UserEnt savedUserEnt = userRepository.save(userEnt);
        return userEntMapper.userToUserMdl(savedUserEnt);
    }

    @Override
    public List<UserMdl> getUsers() {
        List<UserEnt> userEnts = userRepository.findAll();
        return userEntMapper.userListToUserMdlList(userEnts);
    }

    @Override
    public Optional<UserMdl> getUserById(Integer id) {
        Optional<UserEnt> user = userRepository.findById(id);
        return userEntMapper.optionalUserToOptionalUserMdl(user);
    }
}
