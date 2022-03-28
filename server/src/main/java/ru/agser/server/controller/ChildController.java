package ru.agser.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Child;
import ru.agser.server.model.Response;
import ru.agser.server.service.ChildService;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/child")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService childService;

    @GetMapping("/list")
    public String getChildren(Model model) {
        model.addAttribute("children", childService.list(30));
        return "children";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getChild(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("Child retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of("child", childService.get(id)))
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveChild(@RequestBody Child child) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("Child saved")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(Map.of("child", childService.save(child)))
                        .build()
        );
    }

    @GetMapping("/delete/{id}")
    public String deleteChild(@PathVariable("id") Long id) {
        childService.delete(id);
        return "redirect:/child/list";
    }

}
