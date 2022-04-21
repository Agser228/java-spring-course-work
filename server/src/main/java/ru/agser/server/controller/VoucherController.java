package ru.agser.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.dto.Response;
import ru.agser.server.model.dto.Voucher;
import ru.agser.server.service.VoucherService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/voucher")
@CrossOrigin(origins = "http://localhost:3000")
public class VoucherController extends AbstractController<Voucher, VoucherService>{

    public VoucherController(VoucherService voucherService) {
        super(voucherService);
    }


    @GetMapping("")
    public ResponseEntity<Response> getVouchersByStatus(@RequestParam(name = "status") String status) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s save", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, service.getVouchersByStatus(status)))
                        .build()
        );
    }

    @PostMapping("")
    public ResponseEntity<Response> createVoucher(@RequestBody Voucher voucher) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s save", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, service.save(voucher)))
                        .build()
        );
    }

    @PostMapping("/accept/{voucherId}")
    public ResponseEntity<Response> acceptVoucher(@PathVariable Long voucherId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s accepted", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, service.acceptVoucher(voucherId)))
                        .build()
        );
    }

    @PostMapping("/reject/{voucherId}")
    public ResponseEntity<Response> rejectVoucher(@PathVariable Long voucherId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s rejected", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(Map.of(type, service.rejectVoucher(voucherId)))
                        .build()
        );
    }

    @GetMapping("/exist")
    public ResponseEntity<Response> getVoucherByUserId(@RequestParam(name="userId") Long userId){
        Voucher voucher = service.getVoucherByUserId(userId);

        Map<?, ?> data;
        if (voucher == null) {
            data = Map.of("voucher", "");
        } else {
            data = Map.of("voucher", voucher);
        }

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message(String.format("%s rejected", type))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(data)
                        .build()
        );
    }
}
