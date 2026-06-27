package com.kinokz.service.impl;

import com.kinokz.dto.SessionDto;
import com.kinokz.mapper.SessionMapper;
import com.kinokz.repository.SessionRepository;
import com.kinokz.service.SessionService;

import java.util.List;

public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;
    private final SessionMapper mapper;

    public SessionServiceImpl(SessionRepository repository, SessionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SessionDto findById(Long id) {

    }
    @Override
    public List<SessionDto> findAll() {

    }
    @Override
    public SessionDto create(SessionDto dto) {

    }
    @Override
    public void deleteById(Long id) {

    }
    @Override
    public SessionDto updateById(Long id, SessionDto dto) {

    }
}
