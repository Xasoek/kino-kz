package com.kinokz.service;

import com.kinokz.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto findById(Long id);
    List<UserDto> findAll();
    void deleteById(Long id);
    UserDto create(UserDto dto);
    UserDto updateById(Long id, UserDto dto);


}
