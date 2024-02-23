package com.example.hexagonal.adapter.secondary.mapper;

import com.example.hexagonal.adapter.secondary.entity.UserEnt;
import com.example.hexagonal.appcore.model.UserMdl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserEntMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    UserEnt userMdlToUser(UserMdl userMdl);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    UserMdl userToUserMdl(UserEnt userEnt);

    List<UserMdl> userListToUserMdlList(List<UserEnt> userEntList);

    default Optional<UserMdl> optionalUserToOptionalUserMdl(Optional<UserEnt> userOptional) {
        return userOptional.map(this::userToUserMdl);
    }

}
