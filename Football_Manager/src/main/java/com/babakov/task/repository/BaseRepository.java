package com.babakov.task.repository;

import com.babakov.task.models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository <E extends BaseEntity> extends JpaRepository<E, Long> {
}
