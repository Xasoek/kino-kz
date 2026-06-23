package com.kinokz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Movie movie;

    @Column(unique = true, nullable = true)
    private Cinema cinema;

    @Column(unique = true, nullable = false)
    private LocalDateTime startTime;

    @Column(unique = true, nullable = false)
    private int price;
}
