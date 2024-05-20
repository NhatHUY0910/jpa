package com.practice_jpa_2.repository;

import java.util.List;

public interface IGenerateRepository<T> {
    List<T> findAll();

    T findById(int id);

    void save(T t);

    void delete(int id);
}
