package ru.agser.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.agser.server.model.dto.Response;
import ru.agser.server.service.AbstractService;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
public abstract class AbstractController<T, S extends AbstractService<T>>  {
    protected final S service;
    private final String type;


    public AbstractController(S service) {
        this.service = service;
        this.type = this.getClass().getSimpleName().split("Controller")[0].toLowerCase(Locale.ROOT);
    }


    @GetMapping("/list")
    public ResponseEntity<Response> getList() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s retrieved", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, service.list(30)))
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") Long id) {
        T entity = service.getById(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s retrieved", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, entity))
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveChild(@RequestBody T entity) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s saved", type))
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of(type, service.save(entity)))
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s deleted", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("deleted", service.deleteById(id)))
                        .build()
        );
    }
}
