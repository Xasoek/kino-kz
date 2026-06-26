package com.kinokz.service;

import com.kinokz.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    MovieDto findById(Long id);
    List<MovieDto> findAll();
    MovieDto create(MovieDto dto);
    void deleteById(Long id);
    MovieDto updateById(Long id, MovieDto dto);
}
