package ru.agser.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Child;
import ru.agser.server.service.ChildService;


@RestController
@RequestMapping("/api/v1/child")
@CrossOrigin(origins = "http://localhost:3000")
public class ChildController extends AbstractController<Child, ChildService>{

    public ChildController(ChildService service) {
        super(service);
    }
}
