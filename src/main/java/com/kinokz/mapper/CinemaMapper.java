package com.kinokz.mapper;

import com.kinokz.dto.CinemaDto;
import com.kinokz.entity.Cinema;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CinemaMapper {
    CinemaDto toDto(Cinema cinema);
    Cinema toEntity(CinemaDto cinemaDto);
}
