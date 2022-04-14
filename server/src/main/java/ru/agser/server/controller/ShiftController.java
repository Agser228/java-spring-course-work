package ru.agser.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Shift;
import ru.agser.server.service.ShiftService;


@RestController
@RequestMapping("/api/v1/shift")
public class ShiftController extends AbstractController<Shift, ShiftService>{

    public ShiftController(ShiftService service) {
        super(service);
    }
}
