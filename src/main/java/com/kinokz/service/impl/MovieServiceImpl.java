package com.kinokz.service.impl;

import com.kinokz.dto.MovieDto;
import com.kinokz.entity.Movie;
import com.kinokz.mapper.MovieMapper;
import com.kinokz.repository.MovieRepository;
import com.kinokz.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper;

    public MovieServiceImpl(MovieRepository repository, MovieMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MovieDto findById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found")));
    }

    @Override
    public List<MovieDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MovieDto create(MovieDto dto) {
        Movie movie = mapper.toEntity(dto);
        Movie savedMovie = repository.save(movie);
        return mapper.toDto(savedMovie);
    }

    @Override
    public void deleteById(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        repository.delete(movie);
    }

    @Override
    public MovieDto updateById(Long id, MovieDto dto) {
        Movie movie = repository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        movie.setTitle(dto.getTitle());
        movie.setDescription((dto.getDescription()));
        movie.setDuration(dto.getDuration());

        Movie savedMovie = repository.save(movie);
        return mapper.toDto(movie);
    }

}
