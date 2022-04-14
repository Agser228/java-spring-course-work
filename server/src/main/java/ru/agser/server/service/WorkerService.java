package ru.agser.server.service;

import ru.agser.server.enumeration.Position;
import ru.agser.server.model.Worker;

import java.util.List;
import java.util.Map;

public interface WorkerService extends AbstractService<Worker>{
    Map<String, Position> getAllPositions();

    List<Worker> getAllWorkersByPosition(String position);
}
