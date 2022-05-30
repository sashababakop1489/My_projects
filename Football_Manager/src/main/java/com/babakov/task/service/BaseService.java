package com.babakov.task.service;

import com.babakov.task.models.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface BaseService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(Long id);
    E findById(Long id);
    List<E> findAll();


}
