package com.kinokz.repository;

import com.kinokz.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
