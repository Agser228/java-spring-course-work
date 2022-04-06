package ru.agser.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Squad;
import ru.agser.server.service.SquadService;

@RestController
@RequestMapping("/api/v1/squad")
public class SquadController extends AbstractController<Squad, SquadService>{

    @Autowired
    public SquadController(SquadService service) {
        super(service);
    }

}
