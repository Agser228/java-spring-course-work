package ru.agser.server.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agser.server.model.Child;
import ru.agser.server.model.Squad;
import ru.agser.server.model.comparator.AgeChildComparator;
import ru.agser.server.model.dto.RequestCreateSquads;
import ru.agser.server.repo.SquadRepository;
import ru.agser.server.service.ChildService;
import ru.agser.server.service.SquadService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
@Transactional
public class SquadServiceImpl extends AbstractServiceImpl<Squad, SquadRepository> implements SquadService {

    private final ChildService childService;

    @Autowired
    public SquadServiceImpl(SquadRepository repository,
                            ChildService childService) {
        super(repository);
        this.childService = childService;
    }

    @Override
    public List<Squad> createSquads(RequestCreateSquads requestCreateSquads) {
        int amountSquads = requestCreateSquads.getAmountSquads();
        int squadSize = requestCreateSquads.getSquadSize();

        Stack<Child> stackSortedChildren = new Stack<>();
        List<Child> sortedChildren = childService.getAllChildrenSortedBy(new AgeChildComparator());
        stackSortedChildren.addAll(sortedChildren);

        List<List<Child>> splittedChildren = new ArrayList<>();
        for (int i = 0; i < amountSquads; ++i) {
            splittedChildren.add(new ArrayList<>());
        }


        while (!sortedChildren.isEmpty()) {
            for (List<Child> children : splittedChildren) {
                children.add(stackSortedChildren.pop());
            }
        }

        for (List<Child> children : splittedChildren) {
            Squad squad  = new Squad();
            children.forEach(child -> child.setSquad(squad));
            squad.setChildren(children);
            repository.save(squad);
            childService.saveAll(children);
        }

        return new ArrayList<>(getAll());
    }
}
