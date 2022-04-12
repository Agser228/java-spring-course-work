package ru.agser.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.dto.Response;
import ru.agser.server.model.dto.Voucher;
import ru.agser.server.service.VoucherService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/voucher")
@CrossOrigin(origins = "http://localhost:3000")
public class VoucherController {

    private final String type = "voucher";
    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @PostMapping("")
    public ResponseEntity<Response> createVoucher(@RequestBody Voucher voucher) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s save", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, voucherService.saveVoucher(voucher)))
                        .build()
        );
    }
}
