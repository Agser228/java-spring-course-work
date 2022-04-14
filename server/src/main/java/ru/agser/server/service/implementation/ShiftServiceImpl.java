package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.model.Shift;
import ru.agser.server.repo.ShiftRepository;
import ru.agser.server.service.ShiftService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShiftServiceImpl extends AbstractServiceImpl<Shift, ShiftRepository> implements ShiftService {

    public ShiftServiceImpl(ShiftRepository repository) {
        super(repository);
    }
}
