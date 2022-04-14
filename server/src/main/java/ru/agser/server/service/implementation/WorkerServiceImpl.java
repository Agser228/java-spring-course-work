package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.model.Worker;
import ru.agser.server.repo.WorkerRepository;
import ru.agser.server.service.WorkerService;

import javax.transaction.Transactional;

@Service
@Transactional
public class WorkerServiceImpl extends AbstractServiceImpl<Worker, WorkerRepository> implements WorkerService {

    public WorkerServiceImpl(WorkerRepository repository) {
        super(repository);
    }
}
