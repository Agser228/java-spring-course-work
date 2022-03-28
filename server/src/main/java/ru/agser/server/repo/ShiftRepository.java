package ru.agser.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agser.server.model.Shift;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
