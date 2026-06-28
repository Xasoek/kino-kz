package com.kinokz.service.impl;

import com.kinokz.dto.SessionDto;
import com.kinokz.entity.Cinema;
import com.kinokz.entity.Movie;
import com.kinokz.entity.Session;
import com.kinokz.mapper.SessionMapper;
import com.kinokz.repository.CinemaRepository;
import com.kinokz.repository.MovieRepository;
import com.kinokz.repository.SessionRepository;
import com.kinokz.service.SessionService;

import java.util.List;

public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;
    private final SessionMapper mapper;
    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;

    public SessionServiceImpl(
            SessionRepository repository,
            SessionMapper mapper,
            MovieRepository movieRepository,
            CinemaRepository cinemaRepository
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public SessionDto findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Session not found")));
    }
    @Override
    public List<SessionDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();

    }
    @Override
    public SessionDto create(SessionDto dto) {
        Session session = mapper.toEntity(dto);

        Movie movie = movieRepository.findById(dto.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Cinema cinema = cinemaRepository.findById(dto.getCinemaId())
                .orElseThrow(() -> new RuntimeException("Cinema not found"));

        session.setMovie(movie);
        session.setCinema(cinema);

        return mapper.toDto(repository.save(session));
    }

    @Override
    public void deleteById(Long id) {
        Session session = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        repository.delete(session);
    }

    @Override
    public SessionDto updateById(Long id, SessionDto dto) {
        Session session = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        Movie movie = movieRepository.findById(dto.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Cinema cinema = cinemaRepository.findById(dto.getCinemaId())
                .orElseThrow(() -> new RuntimeException("Cinema not found"));

        session.setMovie(movie);
        session.setCinema(cinema);
        session.setStartTime(dto.getStartTime());
        session.setPrice(dto.getPrice());

        Session updatedSession = repository.save(session);

        return mapper.toDto(updatedSession);
    }
}
