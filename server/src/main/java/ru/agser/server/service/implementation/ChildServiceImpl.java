package ru.agser.server.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.agser.server.model.Child;
import ru.agser.server.repo.ChildRepository;
import ru.agser.server.service.ChildService;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ChildServiceImpl implements ChildService {
    private final ChildRepository childRepository;

    @Override
    public Child save(Child child) {
        log.info("Saving new child: {}", child.getName());
        childRepository.save(child);
        return child;
    }

    @Override
    public Collection<Child> list(int limit) {
        log.info("Fetching all children");
        return childRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Child get(Long id) {
        log.info("Fetching child by id: {}", id);
        return childRepository.findById(id).get();
    }

    @Override
    public Child update(Child child) {
        log.info("Updating child {}", child.getName());
        return childRepository.save(child);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting child by id {}", id);
        childRepository.deleteById(id);
        return true;
    }
}
