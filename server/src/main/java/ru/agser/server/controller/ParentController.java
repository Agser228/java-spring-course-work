package ru.agser.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Parent;
import ru.agser.server.service.ParentService;

@RestController
@RequestMapping("/api/v1/parent")
public class ParentController extends AbstractController<Parent, ParentService> {
    public ParentController(ParentService service) {
        super(service);
    }
}
