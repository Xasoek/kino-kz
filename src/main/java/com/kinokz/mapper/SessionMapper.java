package com.kinokz.mapper;

import com.kinokz.dto.SessionDto;
import com.kinokz.entity.Session;
import org.mapstruct.Mapper;

@Mapper
public interface SessionMapper {
    SessionDto toDto(Session session);
}
