package ru.agser.server.service;

import ru.agser.server.model.Child;

import java.util.Collection;

public interface ChildService {
    Child save(Child child);
    Collection<Child> list(int limit);
    Child get(Long id);
    Child update(Child child);
    Boolean delete(Long id);
}
