package ru.agser.server.service;

import ru.agser.server.model.dto.Voucher;

import java.util.List;


public interface VoucherService extends AbstractService<Voucher> {
    Voucher acceptVoucher(Long voucherId);

    Voucher rejectVoucher(Long voucherId);

    List<Voucher> getVouchersByStatus(String status);

    Voucher getVoucherByUserId(Long userId);
}
