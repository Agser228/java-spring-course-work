package ru.agser.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.enumeration.ShiftStatus;
import ru.agser.server.model.Shift;
import ru.agser.server.model.dto.Response;
import ru.agser.server.service.ShiftService;

import java.time.LocalDateTime;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/shift")
@CrossOrigin(origins = "http://localhost:3000")
public class ShiftController extends AbstractController<Shift, ShiftService>{

    public ShiftController(ShiftService service) {
        super(service);
    }

    @GetMapping("")
    ResponseEntity<Response> findAllShiftsByStatus(@RequestParam(name = "status") ShiftStatus status) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s saved", type))
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of(type, service.findAllShiftsByStatus(status)))
                        .build());
    }
}
