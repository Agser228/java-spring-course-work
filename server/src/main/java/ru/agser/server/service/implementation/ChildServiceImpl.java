package ru.agser.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agser.server.model.Child;
import ru.agser.server.repo.ChildRepository;
import ru.agser.server.service.ChildService;

import javax.transaction.Transactional;


@Service
@Transactional
public class ChildServiceImpl extends AbstractServiceImpl<Child, ChildRepository> implements ChildService {

    @Autowired
    public ChildServiceImpl(ChildRepository repository) {
        super(repository);
    }
}
