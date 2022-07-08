package com.company.menumaker.mapper;

import com.company.menumaker.dto.UserDto;
import com.company.menumaker.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userEntityToDto(User user);

    User userDtoToEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);
}
