package ru.agser.server.service;

import ru.agser.server.model.Child;

import java.util.Comparator;
import java.util.List;

public interface ChildService extends AbstractService<Child>{

    List<Child> getAllChildrenSortedBy(Comparator<Child> comparator);
}
