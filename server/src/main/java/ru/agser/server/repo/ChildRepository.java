package ru.agser.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agser.server.model.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
