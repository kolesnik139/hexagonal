package com.example.hexagonal.mapper;

import com.example.hexagonal.appcore.model.UserMdl;
import com.example.hexagonal.adapter.secondary.entity.User;
import com.example.hexagonal.adapter.primary.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    UserDto userMdlToUserDto(UserMdl userMdl);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    UserMdl userDtoToUserMdl(UserDto userDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    User userMdlToUser(UserMdl userMdl);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "birthDate", target = "birthDate")
    UserMdl userToUserMdl(User user);

    List<UserDto> userMdlListToUserDtoList(List<UserMdl> userMdlList);

    List<UserMdl> userDtoListToUserMdlList(List<UserDto> userDtoList);

    List<User> userMdlListToUserList(List<UserMdl> userMdlList);

    List<UserMdl> userListToUserMdlList(List<User> userList);

    default Optional<UserMdl> optionalUserToOptionalUserMdl(Optional<User> userOptional) {
        return userOptional.map(this::userToUserMdl);
    }

}
