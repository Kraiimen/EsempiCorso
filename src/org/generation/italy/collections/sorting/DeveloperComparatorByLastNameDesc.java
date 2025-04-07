package org.generation.italy.collections.sorting;

import java.util.Comparator;

public class DeveloperComparatorByLastNameDesc implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        return o1.getLastName().length() - o2.getLastName().length();
    }
}
