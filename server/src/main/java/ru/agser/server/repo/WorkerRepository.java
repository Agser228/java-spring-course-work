package ru.agser.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agser.server.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
