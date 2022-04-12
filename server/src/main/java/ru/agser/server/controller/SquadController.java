package ru.agser.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Squad;
import ru.agser.server.model.dto.RequestCreateSquads;
import ru.agser.server.model.dto.Response;
import ru.agser.server.service.SquadService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/squad")
public class SquadController extends AbstractController<Squad, SquadService>{

    @Autowired
    public SquadController(SquadService service) {
        super(service);
    }

    @PostMapping("/create-all")
    public ResponseEntity<Response> createSquads(@RequestBody RequestCreateSquads requestCreateSquads) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("squads created")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("squads", service.createSquads(requestCreateSquads)))
                        .build());
    }

}
