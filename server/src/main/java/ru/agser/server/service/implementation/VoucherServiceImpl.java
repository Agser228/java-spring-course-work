package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.model.Child;
import ru.agser.server.model.Parent;
import ru.agser.server.model.dto.Voucher;
import ru.agser.server.service.ChildService;
import ru.agser.server.service.ParentService;
import ru.agser.server.service.VoucherService;

import javax.transaction.Transactional;

@Service
@Transactional
public class VoucherServiceImpl implements VoucherService {

    private final ParentService parentService;
    private final ChildService childService;

    public VoucherServiceImpl(ParentService parentService, ChildService childService) {
        this.parentService = parentService;
        this.childService = childService;
    }
    @Override
    public Voucher saveVoucher(Voucher voucher) {
        Child child = voucher.getChild();
        Parent parent = voucher.getParent();

        child.setParent(parent);
        parent.setChild(child);

        parentService.save(parent);
        childService.save(child);

        return voucher;
    }
}
