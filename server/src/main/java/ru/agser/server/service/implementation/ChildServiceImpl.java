package ru.agser.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agser.server.model.Child;
import ru.agser.server.repo.ChildRepository;
import ru.agser.server.service.ChildService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class ChildServiceImpl extends AbstractServiceImpl<Child, ChildRepository> implements ChildService {

    public ChildServiceImpl(ChildRepository repository) {
        super(repository);
    }

    @Override
    public List<Child> getAllChildrenSortedBy(Comparator<Child> comparator) {
        return new ArrayList<>(
                getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList()));
    }

    @Override
    public long getAmount() {
        return repository.count();
    }
}
