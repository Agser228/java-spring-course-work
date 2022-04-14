package ru.agser.server.repo;

import ru.agser.server.enumeration.Position;
import ru.agser.server.model.Worker;

import java.util.List;

public interface WorkerRepository extends AbstractRepository<Worker> {
    List<Worker> findAllByPosition(Position position);
}
