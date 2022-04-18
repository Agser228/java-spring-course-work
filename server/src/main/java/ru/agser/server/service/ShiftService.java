package ru.agser.server.service;

import ru.agser.server.enumeration.ShiftStatus;
import ru.agser.server.model.Shift;

import java.util.List;

public interface ShiftService extends AbstractService<Shift> {
    List<Shift> findAllShiftsByStatus(ShiftStatus status);
}
