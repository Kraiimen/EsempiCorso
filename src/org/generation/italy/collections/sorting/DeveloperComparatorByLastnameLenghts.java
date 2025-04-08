package org.generation.italy.collections.sorting;

import java.util.Comparator;

public class DeveloperComparatorByLastnameLenghts implements Comparator<Developer> {
    @Override
    public int compare(Developer o1, Developer o2) {
        return o2.getLenghtLastname() - o1.getLenghtLastname();
    }
}
