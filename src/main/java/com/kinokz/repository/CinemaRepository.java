package com.kinokz.repository;

import com.kinokz.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
