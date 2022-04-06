package ru.agser.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.Response;
import ru.agser.server.model.dto.Voucher;
import ru.agser.server.service.ChildService;
import ru.agser.server.service.ParentService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/voucher")
@CrossOrigin(origins = "http://localhost:3000")
public class VoucherController {

    private final String type = "voucher";
    private final ChildService childService;
    private final ParentService parentService;

    @Autowired
    public VoucherController(ChildService childService, ParentService parentService) {
        this.childService = childService;
        this.parentService = parentService;
    }

    @PostMapping("")
    public ResponseEntity<Response> createVoucher(@RequestBody Voucher voucher) {
        childService.save(voucher.getChild());
        parentService.save(voucher.getParent());
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s save", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, voucher))
                        .build()
        );
    }
}
