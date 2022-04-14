package ru.agser.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Squad;
import ru.agser.server.model.dto.Response;
import ru.agser.server.service.SquadService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/squad")
public class SquadController extends AbstractController<Squad, SquadService>{

    public SquadController(SquadService service) {
        super(service);
    }

    @PostMapping("/create-all")
    public ResponseEntity<Response> createSquads(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("squads created")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("squads", service.createSquads(payload)))
                        .build());
    }


    @PostMapping("/{squadId}/attach/{counselorId}")
    public ResponseEntity<Response> attachCounselorToSquad(@PathVariable(name="squadId") Long squadId,
                                                           @PathVariable(name="counselorId") Long counselorId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("squads attached")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("squad", service.attachCounselorToSquad(counselorId, squadId)))
                        .build());
    }

    @PostMapping("/{squadId}/disattach")
    public ResponseEntity<Response> disattachCounselorToSquad(@PathVariable(name="squadId") Long squadId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("squad disattached")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("squad", service.disattachCounselorToSquad(squadId)))
                        .build());
    }

    @GetMapping("")
    public ResponseEntity<Response> getSquadAttachedToCounselor(@RequestParam(name="counselor") Long counselorId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("squads by counselor")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("squad", service.getSquadAttachedToCounselor(counselorId)))
                        .build());
    }

}
