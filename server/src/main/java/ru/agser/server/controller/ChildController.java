package ru.agser.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Child;
import ru.agser.server.service.ChildService;


@RestController
@RequestMapping("/api/v1/child")
public class ChildController extends AbstractController<Child, ChildService>{

    @Autowired
    public ChildController(ChildService service) {
        super(service);
    }
}
