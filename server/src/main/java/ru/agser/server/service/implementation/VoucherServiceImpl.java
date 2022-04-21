package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.enumeration.VoucherStatus;
import ru.agser.server.model.Child;
import ru.agser.server.model.Parent;
import ru.agser.server.model.dto.Voucher;
import ru.agser.server.repo.VoucherRepository;
import ru.agser.server.service.ChildService;
import ru.agser.server.service.ParentService;
import ru.agser.server.service.VoucherService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class VoucherServiceImpl extends AbstractServiceImpl<Voucher, VoucherRepository> implements VoucherService {

    private final ParentService parentService;
    private final ChildService childService;

    public VoucherServiceImpl(ParentService parentService,
                              ChildService childService,
                              VoucherRepository repository) {
        super(repository);
        this.parentService = parentService;
        this.childService = childService;
    }
    @Override
    public Voucher save(Voucher voucher) {
        voucher.setTimeStamp(LocalDateTime.now());
        voucher.setStatus(VoucherStatus.CONSIDERED);
        return super.save(voucher);
    }

    @Override
    public Voucher acceptVoucher(Long voucherId) {
        Voucher voucher = getById(voucherId);
        voucher.setStatus(VoucherStatus.ACCEPTED);

        Child child = new Child();
        child.setAddress(voucher.getChildAddress());
        child.setDateBirth(voucher.getChildDateBirth());
        child.setName(voucher.getChildName());
        child.setSurname(voucher.getChildSurname());
        child.setPatronymic(voucher.getChildPatronymic());
        child.setBirthCertificateNumber(voucher.getChildBirthCertificateNumber());

        Parent parent = new Parent();
        parent.setAddress(voucher.getParentAddress());
        parent.setPlaceIssuePassport(voucher.getParentPlaceIssuePassport());
        parent.setPatronymic(voucher.getParentPatronymic());
        parent.setName(voucher.getParentName());
        parent.setSurname(voucher.getParentSurname());
        parent.setPhoneNumber(voucher.getParentPhoneNumber());
        parent.setSeriesNumberPassport(voucher.getParentSeriesNumberPassport());

        child.setParent(parent);
        parent.setChild(child);

        parentService.save(parent);
        childService.save(child);

        return repository.save(voucher);
    }

    @Override
    public Voucher rejectVoucher(Long voucherId) {
        Voucher voucher = getById(voucherId);
        voucher.setStatus(VoucherStatus.REJECTED);
        return repository.save(voucher);
    }

    @Override
    public List<Voucher> getVouchersByStatus(String statusName) {
        VoucherStatus status = VoucherStatus.valueOf(statusName);
        return repository.findAllByStatus(status);
    }

    @Override
    public Voucher getVoucherByUserId(Long userId) {
        return repository.findVoucherByUserId(userId);
    }
}
