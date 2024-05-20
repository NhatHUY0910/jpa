package com.practice_jpa_2.service;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    void save(T t);
    T findById(int id);
    void delete(int id);
}
