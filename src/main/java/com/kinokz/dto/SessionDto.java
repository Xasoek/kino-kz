package com.kinokz.dto;

import com.kinokz.entity.Cinema;
import com.kinokz.entity.Movie;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionDto {
    private Long movieId;
    private Long cinemaId;
    private LocalDateTime startTime;
    private int price;
}
