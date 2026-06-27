package com.kinokz.service;

import com.kinokz.dto.CinemaDto;
import com.kinokz.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface CinemaService {
    CinemaDto findById(Long id);
    List<CinemaDto> findAll();
    CinemaDto create(CinemaDto cinemaDto);
    void deleteById(Long id);
    CinemaDto updateById(Long id, CinemaDto dto);

}
