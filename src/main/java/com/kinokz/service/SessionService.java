package com.kinokz.service;

import com.kinokz.dto.SessionDto;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    SessionDto findById(Long id);
    List<SessionDto> findAll();
    SessionDto create(SessionDto dto);
    void deleteById(Long id);
    SessionDto updateById(Long id, SessionDto dto);
}
