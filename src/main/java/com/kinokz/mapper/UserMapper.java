package com.kinokz.mapper;

import com.kinokz.dto.UserDto;
import com.kinokz.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);


}
