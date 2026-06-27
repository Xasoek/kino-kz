package com.kinokz.service.impl;

import com.kinokz.dto.CinemaDto;
import com.kinokz.entity.Cinema;
import com.kinokz.mapper.CinemaMapper;
import com.kinokz.repository.CinemaRepository;
import com.kinokz.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaMapper cinemaMapper;
    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository, CinemaMapper cinemaMapper) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaMapper = cinemaMapper;
    }

    @Override
    public CinemaDto findById(Long id) {
        return cinemaMapper.toDto(cinemaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cinema not found")));
    }

    @Override
    public List<CinemaDto> findAll() {
        return cinemaRepository.findAll().stream()
                .map(cinemaMapper::toDto)
                .toList();
    }

    @Override
    public CinemaDto create(CinemaDto dto) {
        Cinema cinema = cinemaMapper.toEntity(dto);
        Cinema savedCinema = cinemaRepository.save(cinema);
        return cinemaMapper.toDto(savedCinema);
    }

    @Override
    public void deleteById(Long id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cinema not found"));

        cinemaRepository.delete(cinema);
    }

    @Override
    public CinemaDto updateById(Long id, CinemaDto dto) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cinema not found"));
        cinema.setName(dto.getName());
        cinema.setAddress((dto.getAddress()));

        Cinema updatedCinema = cinemaRepository.save(cinema);

        return cinemaMapper.toDto(updatedCinema);
    }

}
