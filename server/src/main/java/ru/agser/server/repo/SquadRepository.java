package ru.agser.server.repo;

import ru.agser.server.model.Shift;
import ru.agser.server.model.Squad;
import ru.agser.server.model.Worker;

import java.util.List;

public interface SquadRepository extends AbstractRepository<Squad> {
    List<Squad> findAllByShift(Shift shift);

    Squad findSquadByWorker(Worker counselor);
}
