package ru.agser.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Worker;
import ru.agser.server.service.WorkerService;

@RestController
@RequestMapping("/api/v1/worker")
public class WorkerController extends AbstractController<Worker, WorkerService>{
    public WorkerController(WorkerService service) {
        super(service);
    }
}
