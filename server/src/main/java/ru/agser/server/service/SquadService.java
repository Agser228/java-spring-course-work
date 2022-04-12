package ru.agser.server.service;

import ru.agser.server.model.Squad;
import ru.agser.server.model.dto.RequestCreateSquads;

import java.util.List;

public interface SquadService extends AbstractService<Squad>{
    List<Squad> createSquads(RequestCreateSquads requestCreateSquads);
}
