package com.kinokz.mapper;

import com.kinokz.dto.MovieDto;
import com.kinokz.entity.Movie;
import org.mapstruct.Mapper;

@Mapper
public interface MovieMapper {
    MovieDto toDto(Movie movie);
    Movie toEntity(MovieDto movieDto);
}
