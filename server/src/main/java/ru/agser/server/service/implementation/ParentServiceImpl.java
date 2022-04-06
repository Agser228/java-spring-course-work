package ru.agser.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agser.server.model.Parent;
import ru.agser.server.repo.ParentRepository;
import ru.agser.server.service.ParentService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParentServiceImpl extends AbstractServiceImpl<Parent, ParentRepository> implements ParentService {

    @Autowired
    public ParentServiceImpl(ParentRepository repository) {
        super(repository);
    }
}
