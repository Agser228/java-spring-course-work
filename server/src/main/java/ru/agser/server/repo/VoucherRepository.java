package ru.agser.server.repo;

import ru.agser.server.enumeration.VoucherStatus;
import ru.agser.server.model.dto.Voucher;

import java.util.List;

public interface VoucherRepository extends AbstractRepository<Voucher> {
    List<Voucher> findAllByStatus(VoucherStatus status);
}
