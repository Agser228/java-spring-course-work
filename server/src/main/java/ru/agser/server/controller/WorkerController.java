package ru.agser.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Worker;
import ru.agser.server.model.dto.Response;
import ru.agser.server.service.WorkerService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/worker")
public class WorkerController extends AbstractController<Worker, WorkerService>{
    public WorkerController(WorkerService service) {
        super(service);
    }

    @GetMapping("/positions")
    public ResponseEntity<Response> getAllPositions() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("positions retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("positions", service.getAllPositions()))
                        .build());
    }

    @GetMapping("")
    public ResponseEntity<Response> getAllWorkersByPosition(@RequestParam(name="position") String position) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("positions retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("workers", service.getAllWorkersByPosition(position)))
                        .build());
    }
}
