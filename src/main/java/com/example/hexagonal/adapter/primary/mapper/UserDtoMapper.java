package com.example.hexagonal.adapter.primary.mapper;

import com.example.hexagonal.appcore.model.UserMdl;
import com.example.hexagonal.adapter.primary.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

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


    List<UserDto> userMdlListToUserDtoList(List<UserMdl> userMdlList);

}
