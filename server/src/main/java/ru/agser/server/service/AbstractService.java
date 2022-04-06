package ru.agser.server.service;

import java.util.Collection;

public interface AbstractService<T> {
    T save(T entity);
    Collection<T> list(int limit);
    T getById(Long id);
    T update(T entity);
    Boolean deleteById(Long id);
}
