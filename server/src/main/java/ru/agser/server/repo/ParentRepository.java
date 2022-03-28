package ru.agser.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.agser.server.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
