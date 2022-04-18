package ru.agser.server.repo;

import ru.agser.server.enumeration.ShiftStatus;
import ru.agser.server.model.Shift;

import java.util.List;

public interface ShiftRepository extends AbstractRepository<Shift> {
    List<Shift> findAllByStatus(ShiftStatus status);
}
