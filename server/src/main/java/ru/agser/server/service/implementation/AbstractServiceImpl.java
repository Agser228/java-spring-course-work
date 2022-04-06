package ru.agser.server.service.implementation;
import org.springframework.data.domain.PageRequest;
import ru.agser.server.repo.AbstractRepository;
import ru.agser.server.service.AbstractService;

import java.util.Collection;

public abstract class AbstractServiceImpl<T, R extends AbstractRepository<T>> implements AbstractService<T> {
    R repository;

    public AbstractServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Collection<T> list(int limit) {
        return repository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public T getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public Boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }
}
