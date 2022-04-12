package ru.agser.server.model.comparator;

import ru.agser.server.model.Child;

import java.util.Comparator;

public class AgeChildComparator implements Comparator<Child> {
    @Override
    public int compare(Child c1, Child c2) {
        return Integer.compare(c1.getAge(), c2.getAge());
    }
}
