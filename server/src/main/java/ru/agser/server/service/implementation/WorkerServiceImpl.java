package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.enumeration.Position;
import ru.agser.server.model.Worker;
import ru.agser.server.repo.WorkerRepository;
import ru.agser.server.service.WorkerService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class WorkerServiceImpl extends AbstractServiceImpl<Worker, WorkerRepository> implements WorkerService {

    public WorkerServiceImpl(WorkerRepository repository) {
        super(repository);
    }

    @Override
    public Map<String, Position> getAllPositions() {
        return Position.getPositions();
    }

    @Override
    public List<Worker> getAllWorkersByPosition(String name) {
        Position position = Position.valueOf(name);
        return repository.findAllByPosition(position);
    }
}
