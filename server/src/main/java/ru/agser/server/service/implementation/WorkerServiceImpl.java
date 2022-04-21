package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.enumeration.Position;
import ru.agser.server.model.Worker;
import ru.agser.server.repo.WorkerRepository;
import ru.agser.server.security.User;
import ru.agser.server.security.UserService;
import ru.agser.server.service.WorkerService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WorkerServiceImpl extends AbstractServiceImpl<Worker, WorkerRepository> implements WorkerService {

    private final UserService userService;

    public WorkerServiceImpl(WorkerRepository repository,
                             UserService userService) {
        super(repository);
        this.userService = userService;
    }

    @Override
    public Worker save(Worker worker) {
        User user = userService.signUpWorker(worker.getEmail(), worker.getPhoneNumber());
        worker.setUserId(user.getId());
        return super.save(worker);
    }

    @Override
    public Boolean deleteById(Long id) {
        Worker worker = getById(id);
        userService.deleteById(worker.getUserId());
        return super.deleteById(id);
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
