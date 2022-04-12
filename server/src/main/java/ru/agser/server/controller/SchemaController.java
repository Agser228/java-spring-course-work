package ru.agser.server.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Response;
import ru.agser.server.service.SchemaService;

import java.time.LocalDateTime;
import java.util.Map;

@RequestMapping("/api/v1/schema")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class SchemaController {

    private final SchemaService service;

    @GetMapping("/{entity}")
    public ResponseEntity<Response> getList(@PathVariable(name="entity") String entity) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s schema", entity))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(entity, service.getSchema(entity)))
                        .build()
        );
    }
}
