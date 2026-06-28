package com.kinokz.mapper;

import com.kinokz.dto.SessionDto;
import com.kinokz.entity.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "cinema.id", target = "cinemaId")
    SessionDto toDto(Session session);

    @Mapping(target = "movie", ignore = true)
    @Mapping(target = "cinema", ignore = true)
    Session toEntity(SessionDto dto);
}