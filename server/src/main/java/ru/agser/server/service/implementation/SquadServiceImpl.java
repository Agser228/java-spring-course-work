package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.model.Child;
import ru.agser.server.model.Shift;
import ru.agser.server.model.Squad;
import ru.agser.server.model.Worker;
import ru.agser.server.model.comparator.AgeChildComparator;
import ru.agser.server.repo.SquadRepository;
import ru.agser.server.service.ChildService;
import ru.agser.server.service.ShiftService;
import ru.agser.server.service.SquadService;
import ru.agser.server.service.WorkerService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Transactional
public class SquadServiceImpl extends AbstractServiceImpl<Squad, SquadRepository> implements SquadService {

    private final ChildService childService;
    private final WorkerService workerService;
    private final ShiftService shiftService;

    public SquadServiceImpl(SquadRepository repository,
                            ChildService childService,
                            WorkerService workerService,
                            ShiftService shiftService) {
        super(repository);
        this.childService = childService;
        this.workerService = workerService;
        this.shiftService = shiftService;
    }

    @Override
    public List<Squad> createSquads(Map<String, String> payload) {
        int amountSquads = Integer.parseInt((payload.get("amountSquads")));
        Shift shift = shiftService.getById(Long.parseLong(payload.get("shiftId")));

        // Sort chidlren
        List<Child> sortedChildren = childService.getAllChildrenSortedBy(new AgeChildComparator());
        // Split children
        List<List<Child>> splittedChildren = splitChildrenOnSquadsEvenly(sortedChildren, amountSquads);

        // Squads filled by children
        fillSquadsByChildren(splittedChildren, shift);

        return new ArrayList<>(getAll());
    }

    @Override
    public Squad attachCounselorToSquad(Long counselorId, Long squadId) {
        Worker counselor = workerService.getById(counselorId);
        Squad squad = getById(squadId);
        squad.setWorker(counselor);
        return save(squad);
    }

    @Override
    public Squad disattachCounselorToSquad(Long squadId) {
        Squad squad = getById(squadId);
        squad.setWorker(null);
        return save(squad);
    }

    @Override
    public Child removeChildFromSquad(Long childId, Long squadId) {

        Squad squad = getById(squadId);
        List<Child> filteredChildren = squad.getChildren()
                .stream()
                .filter(c -> !Objects.equals(c.getId(), childId))
                .collect(Collectors.toList());
        squad.setChildren(filteredChildren);

        Child child = childService.getById(childId);
        child.setSquad(null);

        childService.save(child);
        repository.save(squad);
        return child;
    }

    @Override
    public Squad getSquadAttachedToCounselor(Long counselorId) {
        Worker counselor = workerService.getById(counselorId);
        return repository.findSquadByWorker(counselor);
    }

    private void fillSquadsByChildren(List<List<Child>> listChildren, Shift shift) {
        AtomicInteger counter = new AtomicInteger();
        for (List<Child> children : listChildren) {
            Squad squad  = new Squad();
            int averageAge = children
                    .stream()
                    .map(Child::getAge)
                    .reduce(0, Integer::sum) / children.size();
            children.forEach(child -> child.setSquad(squad));

            squad.setChildren(children);
            squad.setAverageAgeChildren(averageAge);
            squad.setShift(shift);
            squad.setNumber(counter.incrementAndGet());

            repository.save(squad);
            childService.saveAll(children);
        }
        shift.setSquads(repository.findAllByShift(shift));
        shift.setAmountPlaces(childService.getAmount());
        shiftService.save(shift);
    }

    private List<List<Child>> splitChildrenOnSquadsEvenly(List<Child> sortedChildren, int amountSquads) {
        Stack<Child> stackSortedChildren = new Stack<>();
        stackSortedChildren.addAll(sortedChildren);

        List<List<Child>> splittedChildren = new ArrayList<>();
        for (int i = 0; i < amountSquads; ++i) {
            splittedChildren.add(new ArrayList<>());
        }
        while (!stackSortedChildren.isEmpty()) {
            for (List<Child> children : splittedChildren) {
                children.add(stackSortedChildren.pop());
                if (stackSortedChildren.isEmpty()) break;
            }
        }

        return splittedChildren;
    }



}
