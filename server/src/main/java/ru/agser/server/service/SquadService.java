package ru.agser.server.service;

import ru.agser.server.model.Child;
import ru.agser.server.model.Squad;

import java.util.List;
import java.util.Map;

public interface SquadService extends AbstractService<Squad>{
    List<Squad> createSquads(Map<String, String> payload);

    Squad attachCounselorToSquad(Long counselorId, Long squadId);

    Squad disattachCounselorToSquad(Long squadId);
    
    Child removeChildFromSquad(Long childId, Long squadId);

    Squad getSquadAttachedToCounselor(Long counselorId);

}
