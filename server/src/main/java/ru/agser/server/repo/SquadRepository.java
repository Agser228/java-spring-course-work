package ru.agser.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agser.server.model.Squad;

public interface SquadRepository extends JpaRepository<Squad, Long> {
}
