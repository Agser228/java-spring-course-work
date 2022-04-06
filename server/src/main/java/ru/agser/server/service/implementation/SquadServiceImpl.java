package ru.agser.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agser.server.model.Squad;
import ru.agser.server.repo.SquadRepository;
import ru.agser.server.service.SquadService;

import javax.transaction.Transactional;

@Service
@Transactional
public class SquadServiceImpl extends AbstractServiceImpl<Squad, SquadRepository> implements SquadService {

    @Autowired
    public SquadServiceImpl(SquadRepository repository) {
        super(repository);
    }
}
